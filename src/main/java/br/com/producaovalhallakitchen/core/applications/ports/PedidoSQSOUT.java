package br.com.producaovalhallakitchen.core.applications.ports;

import br.com.producaovalhallakitchen.adapter.driver.form.SituacaoPedidoForm;

public interface PedidoSQSOUT {

    void publicarAtualizacaoPedido(SituacaoPedidoForm situacaoPedidoForm);
}
