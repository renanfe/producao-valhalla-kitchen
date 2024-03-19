package br.com.producaovalhallakitchen.messaging;

import br.com.producaovalhallakitchen.adapter.driven.infra.messaging.PedidoSQSOUTImpl;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoSQSOUT;
import br.com.producaovalhallakitchen.utils.PedidoHelper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoSQSOUTImplTest {

    private PedidoSQSOUT pedidoSQSOUT;

    @Mock
    private SqsTemplate sqsTemplate;

    @BeforeEach
    void setUp() {
        this.pedidoSQSOUT = new PedidoSQSOUTImpl(sqsTemplate);
    }

    @Test
    void quandoAlteraStatusDoPedido_entaoDevoEncaminharMensagemComOPedido(){
        doReturn(PedidoHelper.buildSendResult()).when(sqsTemplate).send(any());
        this.pedidoSQSOUT.publicarAtualizacaoPedido(PedidoHelper.buildSituacaoPedidoForm());
        verify(this.sqsTemplate, times(1)).send(any());
    }
}
