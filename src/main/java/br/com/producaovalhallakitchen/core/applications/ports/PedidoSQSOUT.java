package br.com.producaovalhallakitchen.core.applications.ports;

import br.com.producaovalhallakitchen.core.domain.Pedido;

public interface PedidoSQSOUT {

    void publicarAtualizacaoPedido(Pedido pedido);
}
