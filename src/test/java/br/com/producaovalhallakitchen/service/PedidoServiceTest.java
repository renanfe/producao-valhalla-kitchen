package br.com.producaovalhallakitchen.service;


import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.core.applications.ports.PedidoRepository;
import br.com.producaovalhallakitchen.core.applications.services.PedidoService;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.utils.PedidoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    PedidoService pedidoService;

    @Mock
    PedidoRepository pedidoRepository;

    @BeforeEach
    void setUp() {
        pedidoService = new PedidoService(pedidoRepository);
    }

    @Test
    public void quandoBuscoTodosOsPedidos_entaoDeveRetornarTodosOsPedidos(){
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoRepository.buscarTodosPedidos()).thenReturn(List.of(pedido));
        List<Pedido> pedidos = pedidoService.buscarTodosPedidos();
        assertNotNull(pedidos);
        verify(pedidoRepository, times(1)).buscarTodosPedidos();
    }

    @Test
    public void quandoBuscoPedidoPorId_entaoDeveRetornarPedido(){
        when(pedidoRepository.buscarPedidoPorId(1L)).thenReturn(Optional.of(PedidoHelper.buildPedido()));
        Optional<Pedido> pedido = pedidoService.buscarPedidoPorId(1L);
        assertTrue(pedido.isPresent());
        verify(pedidoRepository, times(1)).buscarPedidoPorId(any(Long.class));
    }

    @Test
    public void quandoCriarPedido_entaoDeveRetornarPedido(){
        Pedido pedido = PedidoHelper.buildPedido();
        PedidoForm pedidoForm = PedidoHelper.buildPedidoForm();
        when(pedidoRepository.salvarPedido(any(Pedido.class))).thenReturn(pedido);
        Pedido pedidoCriado = pedidoService.criarPedido(pedidoForm);
        assertNotNull(pedidoCriado);
        verify(pedidoRepository, times(1)).salvarPedido(any(Pedido.class));
    }

    @Test
    public void quandoAlterarStatusPedido_entaoDeveRetornarPedido(){
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoRepository.buscarPedidoPorId(any(Long.class))).thenReturn(Optional.of(pedido));
        when(pedidoRepository.salvarPedido(any(Pedido.class))).thenReturn(pedido);
        Optional<Pedido> pedidoAlterado = pedidoService.alterarStatusPedido(1L);
        assertTrue(pedidoAlterado.isPresent());
        verify(pedidoRepository, times(1)).buscarPedidoPorId(any(Long.class));
        verify(pedidoRepository, times(1)).salvarPedido(any(Pedido.class));
    }

    @Test
    public void quandoConsultarFila_entaoDeveRetornarPedidos(){
        Pedido pedido = PedidoHelper.buildPedido();
        when(pedidoRepository.buscarFilaPedidos(any(List.class))).thenReturn(List.of(pedido));
        List<Pedido> pedidos = pedidoService.consultarFila();
        assertNotNull(pedidos);
        verify(pedidoRepository, times(1)).buscarFilaPedidos(any(List.class));
    }


}
