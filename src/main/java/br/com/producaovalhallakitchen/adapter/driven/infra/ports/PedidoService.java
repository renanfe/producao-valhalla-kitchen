package br.com.producaovalhallakitchen.adapter.driven.infra.ports;

import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.core.domain.Pedido;

public interface PedidoService {

    Pedido criarPedido(PedidoForm pedidoForm);

}
