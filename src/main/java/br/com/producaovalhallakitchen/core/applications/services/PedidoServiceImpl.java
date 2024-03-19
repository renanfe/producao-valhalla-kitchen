package br.com.producaovalhallakitchen.core.applications.services;

import br.com.producaovalhallakitchen.adapter.driven.infra.ports.PedidoService;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.adapter.utils.mappers.PedidoMapper;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoRepository;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoSQSOUT;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.core.domain.Status;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    private final PedidoSQSOUT pedidoSQSOUT;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, PedidoSQSOUT pedidoSQSOUT) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoSQSOUT = pedidoSQSOUT;
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
        Optional<Pedido> pedidoAtualizado = pedidoRepository.buscarPedidoPorId(id)
                .map(pedido -> atualizarParaProximoStatus(pedido, pedido.getStatus()))
                .map(pedidoRepository::salvarPedido);
        if (pedidoAtualizado.isPresent()) {
            pedidoSQSOUT.publicarAtualizacaoPedido(PedidoMapper.pagamentoToSituacaoPedidoForm(pedidoAtualizado.get()));
        }
        return pedidoAtualizado;
    }

    private Pedido atualizarParaProximoStatus(Pedido pedido, Status status) {
        switch (status) {
            case RECEBIDO -> pedido.setStatus(Status.EM_PREPARACAO);
            case EM_PREPARACAO -> pedido.setStatus(Status.PRONTO);
            case PRONTO -> pedido.setStatus(Status.RETIRADO);
            case RETIRADO -> pedido.setStatus(Status.FINALIZADO);
            default -> throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        return pedido;
    }

    public List<Pedido> consultarFila() {
        List<Status> status = Arrays.asList(Status.PRONTO, Status.EM_PREPARACAO, Status.RECEBIDO);
        return pedidoRepository.buscarFilaPedidos(status);
    }

}
