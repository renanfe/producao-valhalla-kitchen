package br.com.producaovalhallakitchen.adapter.driver.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoForm {
    private String nome;
    private int quantidade;
}
