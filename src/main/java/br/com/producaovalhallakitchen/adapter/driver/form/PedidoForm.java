package br.com.producaovalhallakitchen.adapter.driver.form;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class PedidoForm {
    private Long pedidoId;
    private List<ProdutoForm> produtosForm;
}