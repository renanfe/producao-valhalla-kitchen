package br.com.producaovalhallakitchen.core.applications.services;

import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.adapter.utils.mappers.PedidoMapper;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoRepository;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> buscarTodosPedidos() {
        return pedidoRepository.buscarTodosPedidos();
    }

    public Optional<Pedido> buscarPedidoPorId(String id) {
        return pedidoRepository.buscarPedidoPorId(id);
    }

    public Pedido criarPedido(PedidoForm pedidoForm) {
        return pedidoRepository.salvarPedido(PedidoMapper.pedidoFormToPedido(pedidoForm));
    }

    public Optional<Pedido> alterarStatusPedido(String id) {
        Optional<Pedido> pedido = pedidoRepository.buscarPedidoPorId(id);

        if (pedido.isPresent()) {
            Pedido pedidoAtualizado = atualizarParaProximoStatus(pedido.get(), pedido.get().getStatus());
            pedidoRepository.salvarPedido(pedidoAtualizado);

            return Optional.of(pedidoAtualizado);
        }
        return pedido;
    }

    private Pedido atualizarParaProximoStatus(Pedido pedido, String status) {
        switch (status) {
            case "Recebido" -> pedido.setStatus("Em preparação");
            case "Em preparação" -> pedido.setStatus("Pronto");
            case "Pronto" -> pedido.setStatus("Retirado");
            case "Retirado" -> pedido.setStatus("Finalizado");
            default -> throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        return pedido;
    }

    public List<Pedido> consultarFila() {
        List<String> status = Arrays.asList("Pronto", "Em preparação", "Recebido");
        return pedidoRepository.buscarFilaPedidos(status);
    }

}
