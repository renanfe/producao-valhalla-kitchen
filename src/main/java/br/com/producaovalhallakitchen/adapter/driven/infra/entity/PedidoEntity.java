package br.com.producaovalhallakitchen.adapter.driven.infra.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
@Builder
@Getter
@Setter
@Document("pedido")
public class PedidoEntity {

    public PedidoEntity (String id, UUID clienteId, String nomeCliente, String status, List<Long> produtos, String statusPagamento) {
        this.id = id;
        this.clienteId = clienteId;
        this.nomeCliente = nomeCliente;
        this.status = status;
        this.produtos = produtos;
        this.statusPagamento = statusPagamento;
    }

    @Id
    private String id;

    private UUID clienteId;

    private String nomeCliente;

    private String status = "Recebido";

    private List<Long> produtos;

    private String statusPagamento = "Aguardando";
}
