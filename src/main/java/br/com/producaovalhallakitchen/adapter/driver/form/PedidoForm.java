package br.com.producaovalhallakitchen.adapter.driver.form;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class PedidoForm {
    private List<Long> produtosId;
    private UUID clienteId;
    private String nomeCliente;
}
