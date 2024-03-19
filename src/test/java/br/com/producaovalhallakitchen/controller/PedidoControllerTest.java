package br.com.producaovalhallakitchen.controller;

import br.com.producaovalhallakitchen.adapter.driver.PedidoController;
import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.core.applications.services.PedidoServiceImpl;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.utils.PedidoHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PedidoControllerTest {

    @Mock
    private PedidoServiceImpl pedidoService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        PedidoController underTest = new PedidoController(pedidoService);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    void quandoEuReceboUmPedido_entaoOPedidoDeveSerCadastrado() throws Exception{
        PedidoForm pedidoForm = PedidoHelper.buildPedidoForm();
        when(pedidoService.criarPedido(any(PedidoForm.class))).thenReturn(PedidoHelper.buildPedido());
        mockMvc.perform(post("/v1/pedidos")
                        .content(new ObjectMapper().writeValueAsString(pedidoForm))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(pedidoService, times(1)).criarPedido(any(PedidoForm.class));
    }
    @Test
    void quandoSolicitoTodosOsPedidos_entaoDevoRetornarOPedido() throws Exception{
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoService.buscarTodosPedidos()).thenReturn(List.of(pedido));
        mockMvc.perform(get("/v1/pedidos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pedidoService, times(1)).buscarTodosPedidos();
    }

    @Test
    void quandoSolicitoUmPedidoPorId_entaoDevoRetornarOPedido() throws Exception{
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoService.buscarPedidoPorId(any(String.class))).thenReturn(Optional.of(pedido));
        mockMvc.perform(get("/v1/pedidos/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pedidoService, times(1)).buscarPedidoPorId(any(String.class));
    }

    @Test
    void quandoSolicitoAFilaDePedidos_entaoDevoRetornarAFilaDePedidos() throws Exception{
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoService.consultarFila()).thenReturn(List.of(pedido));
        mockMvc.perform(get("/v1/pedidos/fila")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pedidoService, times(1)).consultarFila();
    }

    @Test
    void quandoSolicitoAAlteraçãoDoPedido_entaoAlterarOStatusDoPedidoERetornarOMesmo() throws Exception{
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoService.alterarStatusPedido(any(String.class))).thenReturn(Optional.of(pedido));
        mockMvc.perform(patch("/v1/pedidos/{Id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pedidoService, times(1)).alterarStatusPedido(any(String.class));
    }
}
