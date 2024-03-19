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
    private Status status = Status.RECEBIDO;

    private List<Produto> produtos;
}