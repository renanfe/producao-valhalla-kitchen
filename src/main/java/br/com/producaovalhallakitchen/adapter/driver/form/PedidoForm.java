package br.com.producaovalhallakitchen.adapter.driver.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoForm {
    private Long pedidoId;
    private List<ProdutoForm> produtosForm;
}