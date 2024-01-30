package br.com.producaovalhallakitchen.controller;

import br.com.producaovalhallakitchen.adapter.driver.PedidoController;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.core.applications.services.PedidoService;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.utils.PedidoHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PedidoController.class) //Setar controlador
@ExtendWith(MockitoExtension.class)
public class PedidoControllerTest {

    @MockBean
    private PedidoService pedidoService;
    @Autowired
    private MockMvc mvc;
    @Test
    public void quandoEuReceboUmPedido_entaoOPedidoDeveSerCadastrado() throws Exception{
        PedidoForm pedidoForm = PedidoHelper.buildPedidoForm();
        when(pedidoService.criarPedido(any(PedidoForm.class))).thenReturn(PedidoHelper.buildPedido());
        mvc.perform(post("/v1/pedidos")
                        .content(new ObjectMapper().writeValueAsString(pedidoForm))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(pedidoService, times(1)).criarPedido(any(PedidoForm.class));
    }
    @Test
    public void quandoSolicitoTodosOsPedidos_entaoDevoRetornarOPedido() throws Exception{
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoService.buscarTodosPedidos()).thenReturn(List.of(pedido));
        mvc.perform(get("/v1/pedidos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pedidoService, times(1)).buscarTodosPedidos();
    }

    @Test
    public void quandoSolicitoUmPedidoPorId_entaoDevoRetornarOPedido() throws Exception{
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoService.buscarPedidoPorId(any(Long.class))).thenReturn(Optional.of(pedido));
        mvc.perform(get("/v1/pedidos/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pedidoService, times(1)).buscarPedidoPorId(any(Long.class));
    }

    @Test
    public void quandoSolicitoAFilaDePedidos_entaoDevoRetornarAFilaDePedidos() throws Exception{
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoService.consultarFila()).thenReturn(List.of(pedido));
        mvc.perform(get("/v1/pedidos/fila")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pedidoService, times(1)).consultarFila();
    }

    @Test
    public void quandoSolicitoAAlteraçãoDoPedido_entaoAlterarOStatusDoPedidoERetornarOMesmo() throws Exception{
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoService.alterarStatusPedido(any(Long.class))).thenReturn(Optional.of(pedido));
        mvc.perform(patch("/v1/pedidos/{Id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pedidoService, times(1)).alterarStatusPedido(any(Long.class));
    }
}
