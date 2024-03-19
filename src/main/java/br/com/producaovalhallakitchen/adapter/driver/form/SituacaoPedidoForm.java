package br.com.producaovalhallakitchen.adapter.driver.form;

import br.com.producaovalhallakitchen.core.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SituacaoPedidoForm {

    private Long pedidoId;
    private Status status;

}
