package br.com.producaovalhallakitchen.adapter.driven.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@Setter
@Document("pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoEntity {
    @MongoId
    private String id;

    private Long pedidoId;

    private String status;

    private List<ProdutoEntity> produtos;

}