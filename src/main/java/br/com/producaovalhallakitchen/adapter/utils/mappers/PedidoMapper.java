package br.com.producaovalhallakitchen.adapter.utils.mappers;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.adapter.driver.form.SituacaoPedidoForm;
import br.com.producaovalhallakitchen.core.domain.Pedido;

public class PedidoMapper {
    private PedidoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static PedidoEntity pedidoToEntity(Pedido pedido) {
        return PedidoEntity.builder()
                .id(pedido.getId())
                .pedidoId(pedido.getPedidoId())
                .status(pedido.getStatus())
                .produtos(ProdutoMapper.produtoToEntity(pedido.getProdutos()))
                .build();
    }

    public static Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity) {
        return Pedido.builder()
                .id(pedidoEntity.getId())
                .pedidoId(pedidoEntity.getPedidoId())
                .status(pedidoEntity.getStatus())
                .produtos(ProdutoMapper.produtoEntityToProduto(pedidoEntity.getProdutos()))
                .build();
    }

    public static Pedido pedidoFormToPedido(PedidoForm pedidoForm) {
        return Pedido.builder()
                .pedidoId(pedidoForm.getPedidoId())
                .produtos(ProdutoMapper.produtoFormToProduto(pedidoForm.getProdutosForm()))
                .build();
    }

    public static SituacaoPedidoForm pagamentoToSituacaoPedidoForm (Pedido pedidoAtualizado) {
        return SituacaoPedidoForm.builder()
                .pedidoId(pedidoAtualizado.getPedidoId())
                .status(pedidoAtualizado.getStatus())
                .build();
    }
}
