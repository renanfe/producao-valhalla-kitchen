package br.com.producaovalhallakitchen.adapter.driver.form;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoForm {
    private Long pedidoId;
    private List<ProdutoForm> produtos;
}