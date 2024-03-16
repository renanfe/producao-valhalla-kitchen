package br.com.producaovalhallakitchen.adapter.utils.mappers;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driven.infra.entity.ProdutoEntity;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.adapter.driver.form.ProdutoForm;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.core.domain.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapper {

    private ProdutoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static List<ProdutoEntity> produtoToEntity(List<Produto> produtos) {
        List<ProdutoEntity> produtosEntity = new ArrayList<>();

        for (Produto produto : produtos) {
            produtosEntity.add(ProdutoEntity.builder()
                    .nome(produto.getNome())
                    .quantidade(produto.getQuantidade())
                    .build());
        }

        return produtosEntity;
    }

    public static List<Produto> produtoEntityToProduto(List<ProdutoEntity> produtosEntity) {
        List<Produto> produtos = new ArrayList<>();

        for (ProdutoEntity produtoEntity : produtosEntity) {
            produtos.add(Produto.builder()
                    .nome(produtoEntity.getNome())
                    .quantidade(produtoEntity.getQuantidade())
                    .build());
        }

        return produtos;
    }

    public static List<Produto> produtoFormToProduto(List<ProdutoForm> produtosForm) {
        List<Produto> produtos = new ArrayList<>();

        for (ProdutoForm produtoForm : produtosForm) {
            produtos.add(Produto.builder()
                            .nome(produtoForm.getNome())
                            .quantidade(produtoForm.getQuantidade())
                            .build());
        }

        return produtos;
    }

}
