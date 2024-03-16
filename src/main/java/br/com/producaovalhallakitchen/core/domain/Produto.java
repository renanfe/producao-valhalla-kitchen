package br.com.producaovalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Produto {
    private String nome;
    private int quantidade;
}