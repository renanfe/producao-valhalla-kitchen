package br.com.producaovalhallakitchen.adapter.driven.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoEntity {
    private String nome;
    private int quantidade;
}