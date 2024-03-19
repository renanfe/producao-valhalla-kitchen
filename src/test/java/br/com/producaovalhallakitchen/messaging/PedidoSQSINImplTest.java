package br.com.producaovalhallakitchen.messaging;

import br.com.producaovalhallakitchen.adapter.driven.infra.messaging.PedidoSQSINImpl;
import br.com.producaovalhallakitchen.adapter.driven.infra.ports.PedidoService;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoSQSIN;
import br.com.producaovalhallakitchen.utils.PedidoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoSQSINImplTest {

    private PedidoSQSIN pedidoSQSIN;

    @Mock
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        this.pedidoSQSIN = new PedidoSQSINImpl(pedidoService);
    }

    @Test
    void quandoEuReceboUmPedidoAprovado_entaoDevoProcessarOPedidoComSucesso(){
        doReturn(PedidoHelper.buildPedido()).when(pedidoService).criarPedido(any());
        this.pedidoSQSIN.receberMensagem(PedidoHelper.buildMessage());
        verify(this.pedidoService, times(1)).criarPedido(any());
    }

}
