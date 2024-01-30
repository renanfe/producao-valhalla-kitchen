package br.com.producaovalhallakitchen.utils;

import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.core.domain.Pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class PedidoHelper {
    public static PedidoForm buildPedidoForm(){
        return PedidoForm.builder()
                .clienteId(UUID.randomUUID())
                .nomeCliente("Teste")
                .produtosId(List.of(gerarLong()))
                .build();
    }

    public static Pedido buildPedido(){
        return Pedido.builder()
                .produtos(List.of(gerarLong()))
                .id(gerarLong())
                .nomeCliente("Teste")
                .clienteId(UUID.randomUUID())
                .build();
    }

    public static long gerarLong() {
        return new Random().nextLong();
    }

    public static BigDecimal gerarBigDecimal() {
        return BigDecimal.ONE;
    }

    public static PedidoEntity buildPedidoEntity () {
        return PedidoEntity.builder()
                .id(gerarLong())
                .clienteId(UUID.randomUUID())
                .nomeCliente("Teste")
                .produtos(List.of(gerarLong()))
                .build();
    }

}
