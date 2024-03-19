package br.com.producaovalhallakitchen.core.applications.ports;

import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

public interface PedidoSQSIN {

    void receberMensagem(@Payload Message<PedidoForm> message);

}
