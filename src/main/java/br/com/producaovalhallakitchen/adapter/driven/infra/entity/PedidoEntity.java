package br.com.producaovalhallakitchen.adapter.driven.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "pedido_generator", sequenceName = "pedido_id_seq", allocationSize = 1)
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "clienteId")
    private UUID clienteId;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "status")
    @Builder.Default
    private String status = "Recebido";

    @ElementCollection
    @CollectionTable(name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"))
    @Column(name = "produto_id")
    private List<Long> produtos;

    @Column(name = "status_pagamento")
    @Builder.Default
    private String statusPagamento = "Aguardando";
}
