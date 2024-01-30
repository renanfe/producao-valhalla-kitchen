package br.com.producaovalhallakitchen.repository;

import br.com.producaovalhallakitchen.adapter.driven.infra.PedidoRepositoryImpl;
import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driven.infra.jpa.PedidoRepositoryJpa;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.utils.PedidoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
public class PedidoRepositoryTest {

    private PedidoRepositoryImpl pedidoRepository;
    @Mock
    private PedidoRepositoryJpa pedidoRepositoryJpa ;

    @BeforeEach
    void setUp() {
        pedidoRepository = new PedidoRepositoryImpl(pedidoRepositoryJpa);
    }

    @Test
    public void quandoEuSalvoUmPedido_entaoDeveSalvarOPedido(){
        PedidoEntity pedidoEntity = PedidoHelper.buildPedidoEntity();
        when(pedidoRepositoryJpa.save(any(PedidoEntity.class))).thenReturn(pedidoEntity);
        Pedido pedido = pedidoRepository.salvarPedido(PedidoHelper.buildPedido());
        assertNotNull(pedido);
        verify(pedidoRepositoryJpa, times(1)).save(any(PedidoEntity.class));
    }
    @Test
    public void quandoBuscoTodosOsPedidos_entaoDeveBuscarTodosOsPedidosNaBase(){
        PedidoEntity pedidoEntity = PedidoHelper.buildPedidoEntity();
        when(pedidoRepositoryJpa.findAll()).thenReturn(List.of(pedidoEntity));
        List<Pedido> pedido = pedidoRepository.buscarTodosPedidos();
        assertNotNull(pedido);
        verify(pedidoRepositoryJpa, times(1)).findAll();
    }

    @Test
    public void quandoBuscoUmPedidoPorId_entaoDeveBuscarOPedidoNaBase(){
        PedidoEntity pedidoEntity = PedidoHelper.buildPedidoEntity();
        when(pedidoRepositoryJpa.findById(anyLong())).thenReturn(java.util.Optional.of(pedidoEntity));
        var pedido = pedidoRepository.buscarPedidoPorId(1L);
        assertTrue(pedido.isPresent());
        verify(pedidoRepositoryJpa, times(1)).findById(anyLong());
    }

    @Test
    public void quandoBuscoFilaDePedidos_entaoDeveBuscarFilaDePedidosNaBase(){
        PedidoEntity pedidoEntity = PedidoHelper.buildPedidoEntity();
        when(pedidoRepositoryJpa.findByStatusIn(anyList())).thenReturn(List.of(pedidoEntity));
        List<Pedido> pedido = pedidoRepository.buscarFilaPedidos(List.of("Recebido", "Em preparação", "Pronto"));
        assertNotNull(pedido);
        verify(pedidoRepositoryJpa, times(1)).findByStatusIn(anyList());
    }
}
