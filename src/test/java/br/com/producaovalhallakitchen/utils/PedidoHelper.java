package br.com.producaovalhallakitchen.utils;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driven.infra.entity.ProdutoEntity;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.adapter.driver.form.ProdutoForm;
import br.com.producaovalhallakitchen.adapter.driver.form.SituacaoPedidoForm;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.core.domain.Produto;
import br.com.producaovalhallakitchen.core.domain.Status;
import io.awspring.cloud.sqs.operations.SendResult;
import io.swagger.v3.core.util.Json;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PedidoHelper {
    public static PedidoForm buildPedidoForm(){
        List<ProdutoForm> produtosForm = new ArrayList<>();
        produtosForm.add(ProdutoForm.builder().nome("Odin").quantidade(1).build());

        return PedidoForm.builder()
                .pedidoId(1L)
                .produtos(produtosForm)
                .build();
    }

    public static Pedido buildPedido(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder().nome("Odin").quantidade(1).build());

        return Pedido.builder()
                .pedidoId(1L)
                .status(Status.RECEBIDO)
                .produtos(produtos)
                .build();
    }

    public static PedidoEntity buildPedidoEntity () {
        List<ProdutoEntity> produtosEntity = new ArrayList<>();
        produtosEntity.add(ProdutoEntity.builder().nome("Odin").quantidade(1).build());

        return PedidoEntity.builder()
                .id("65f50c3184f63148281e01fe")
                .status(Status.EM_PREPARACAO)
                .pedidoId(1L)
                .produtos(produtosEntity)
                .build();
    }

    public static SendResult buildSendResult() {
        return new SendResult(UUID.randomUUID(), "teste.com.br", buildMessage(), null);
    }
    public static Message<String> buildMessage() {
        return new GenericMessage<String>(Json.pretty(buildPedidoForm()));
    }

    public static SituacaoPedidoForm buildSituacaoPedidoForm() {
        return SituacaoPedidoForm.builder()
                .pedidoId(1L)
                .status(Status.RECEBIDO)
                .build();
    }

}
