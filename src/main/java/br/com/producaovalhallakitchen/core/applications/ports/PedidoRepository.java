package br.com.producaovalhallakitchen.core.applications.ports;

import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.core.domain.Status;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    List<Pedido> buscarTodosPedidos();

    Optional<Pedido> buscarPedidoPorId(String id);

    Pedido salvarPedido(Pedido pedido);

    List<Pedido> buscarFilaPedidos(List<Status> status);

}
