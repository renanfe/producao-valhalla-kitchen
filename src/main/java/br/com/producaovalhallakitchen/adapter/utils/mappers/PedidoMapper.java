package br.com.producaovalhallakitchen.adapter.utils.mappers;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.core.domain.Pedido;

public class PedidoMapper {
    private PedidoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static PedidoEntity pedidoToEntity(Pedido pedido) {
        return PedidoEntity.builder()
                .id(pedido.getId())
                .clienteId(pedido.getClienteId())
                .nomeCliente(pedido.getNomeCliente())
                .status(pedido.getStatus())
                .statusPagamento(pedido.getStatusPagamento())
                .produtos(pedido.getProdutos())
                .build();
    }

    public static Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity) {
        return Pedido.builder()
                .id(pedidoEntity.getId())
                .clienteId(pedidoEntity.getClienteId())
                .nomeCliente(pedidoEntity.getNomeCliente())
                .status(pedidoEntity.getStatus())
                .statusPagamento(pedidoEntity.getStatusPagamento())
                .produtos(pedidoEntity.getProdutos())
                .build();
    }

    public static Pedido pedidoFormToPedido(PedidoForm pedidoForm) {
        return Pedido.builder()
                .clienteId(pedidoForm.getClienteId())
                .nomeCliente(pedidoForm.getNomeCliente())
                .produtos(pedidoForm.getProdutosId())
                .build();
    }
}
