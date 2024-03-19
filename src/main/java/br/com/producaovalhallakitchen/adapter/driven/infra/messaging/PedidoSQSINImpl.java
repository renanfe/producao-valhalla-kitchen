package br.com.producaovalhallakitchen.adapter.driven.infra.messaging;

import br.com.producaovalhallakitchen.adapter.driven.infra.ports.PedidoService;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoSQSIN;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class PedidoSQSINImpl implements PedidoSQSIN {
    private final PedidoService pedidoService;

    public PedidoSQSINImpl(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    @SqsListener(value = "${queue.pedido-aprovado}")
    public void receberMensagem(Message<PedidoForm> message) {
        this.pedidoService.criarPedido(message.getPayload());
    }
}
