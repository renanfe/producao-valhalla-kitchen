package br.com.producaovalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Pedido {

    private Long id;
    @Builder.Default
    @Setter
    private String status = "Recebido";

    private UUID clienteId;
    private String nomeCliente;

    private List<Long> produtos;

    @Builder.Default
    private String statusPagamento = "Aguardando";
}