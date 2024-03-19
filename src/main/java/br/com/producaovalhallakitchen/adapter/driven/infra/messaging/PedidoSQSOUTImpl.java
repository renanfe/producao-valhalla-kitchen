package br.com.producaovalhallakitchen.adapter.driven.infra.messaging;

import br.com.producaovalhallakitchen.adapter.driver.form.SituacaoPedidoForm;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoSQSOUT;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PedidoSQSOUTImpl implements PedidoSQSOUT {

    private final SqsTemplate sqsTemplate;

    @Value("${queue.atualizacao-situacao-pedido}")
    private String queueAtualizacaoSituacaoPedido;

    public PedidoSQSOUTImpl(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    @Override
    public void publicarAtualizacaoPedido(SituacaoPedidoForm situacaoPedidoForm) {
        this.sqsTemplate
                .send(sqsSendOptions ->
                        sqsSendOptions
                                .queue(queueAtualizacaoSituacaoPedido)
                                .payload(situacaoPedidoForm)
                );
    }
}
