package br.com.producaovalhallakitchen.utils;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driven.infra.entity.ProdutoEntity;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.adapter.driver.form.ProdutoForm;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.core.domain.Produto;
import io.awspring.cloud.sqs.operations.SendResult;
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
                .produtosForm(produtosForm)
                .build();
    }

    public static Pedido buildPedido(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder().nome("Odin").quantidade(1).build());

        return Pedido.builder()
                .pedidoId(1L)
                .status("Recebido")
                .produtos(produtos)
                .build();
    }

    public static PedidoEntity buildPedidoEntity () {
        List<ProdutoEntity> produtosEntity = new ArrayList<>();
        produtosEntity.add(ProdutoEntity.builder().nome("Odin").quantidade(1).build());

        return PedidoEntity.builder()
                .id("65f50c3184f63148281e01fe")
                .status("Em preparação")
                .pedidoId(1L)
                .produtos(produtosEntity)
                .build();
    }

    public static SendResult buildSendResult() {
        return new SendResult(UUID.randomUUID(), "teste.com.br", buildMessage(), null);
    }
    public static Message<PedidoForm> buildMessage() {
        return new GenericMessage<PedidoForm>(buildPedidoForm());
    }

}
