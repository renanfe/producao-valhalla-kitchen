package br.com.producaovalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Builder
public class Pedido {

    private String id;

    private Long pedidoId;

    @Builder.Default
    @Setter
    private String status = "Recebido";

    private List<Produto> produtos;
}