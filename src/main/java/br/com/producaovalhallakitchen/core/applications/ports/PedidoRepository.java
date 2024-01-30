package br.com.producaovalhallakitchen.core.applications.ports;

import br.com.producaovalhallakitchen.core.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    List<Pedido> buscarTodosPedidos();

    Optional<Pedido> buscarPedidoPorId(Long id);

    Pedido salvarPedido(Pedido pedido);

    List<Pedido> buscarFilaPedidos(List<String> status);

}
