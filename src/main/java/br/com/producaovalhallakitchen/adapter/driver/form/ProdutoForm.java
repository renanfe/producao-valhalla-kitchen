package br.com.producaovalhallakitchen.adapter.driver.form;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProdutoForm {
    private String nome;
    private int quantidade;
}
