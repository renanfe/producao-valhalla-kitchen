package br.com.producaovalhallakitchen.utils;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driven.infra.entity.ProdutoEntity;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.adapter.driver.form.ProdutoForm;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.core.domain.Produto;

import java.util.ArrayList;
import java.util.List;

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

}
