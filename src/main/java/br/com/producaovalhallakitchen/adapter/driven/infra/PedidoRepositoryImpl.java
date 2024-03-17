package br.com.producaovalhallakitchen.adapter.driven.infra;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driven.infra.jpa.PedidoRepositoryMongo;
import br.com.producaovalhallakitchen.adapter.utils.mappers.PedidoMapper;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoRepository;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoRepositoryMongo pedidoRepositoryMongo;

    public PedidoRepositoryImpl(PedidoRepositoryMongo pedidoRepositoryMongo) {
        this.pedidoRepositoryMongo = pedidoRepositoryMongo;
    }

    @Override
    public List<Pedido> buscarTodosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoEntity pedido : pedidoRepositoryMongo.findAll()) {
            pedidos.add(PedidoMapper.pedidoEntityToPedido(pedido));
        }

        return pedidos;
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(String id) {
        return pedidoRepositoryMongo.findById(id).map(PedidoMapper::pedidoEntityToPedido);
    }

    @Override
    public Pedido salvarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoRepositoryMongo.save(PedidoMapper.pedidoToEntity(pedido));
        return PedidoMapper.pedidoEntityToPedido(pedidoEntity);
    }

    @Override
    public List<Pedido> buscarFilaPedidos(List<String> status) {
        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoEntity pedido : pedidoRepositoryMongo.findByStatusIn(status)) {
            pedidos.add(PedidoMapper.pedidoEntityToPedido(pedido));
        }
        pedidos.sort(Comparator.comparing(pedido -> {
            String statusPedido = pedido.getStatus();
            if (statusPedido.equals("Pronto")) {
                return 1;
            } else if (statusPedido.equals("Em preparação")) {
                return 2;
            } else if (statusPedido.equals("Recebido")) {
                return 3;
            } else {
                return 4; // Para outros status não especificados
            }
        }));
        return pedidos;
    }
}
