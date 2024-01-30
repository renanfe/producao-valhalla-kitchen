package br.com.producaovalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Pedido {

    private Long id;
    @Builder.Default
    private String status = "Recebido";

    private UUID clienteId;
    private String nomeCliente;

    private List<Produto> produtos;

    @Builder.Default
    private String statusPagamento = "Aguardando";
}