package br.com.producaovalhallakitchen.repository;

import br.com.producaovalhallakitchen.adapter.driven.infra.PedidoRepositoryImpl;
import br.com.producaovalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.producaovalhallakitchen.adapter.driven.infra.jpa.PedidoRepositoryMongo;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import br.com.producaovalhallakitchen.utils.PedidoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class PedidoRepositoryTest {

    private PedidoRepositoryImpl pedidoRepository;
    @Mock
    private PedidoRepositoryMongo pedidoRepositoryJpa ;

    @BeforeEach
    void setUp() {
        pedidoRepository = new PedidoRepositoryImpl(pedidoRepositoryJpa);
    }

    @Test
    void quandoEuSalvoUmPedido_entaoDeveSalvarOPedido(){
        PedidoEntity pedidoEntity = PedidoHelper.buildPedidoEntity();
        when(pedidoRepositoryJpa.save(any(PedidoEntity.class))).thenReturn(pedidoEntity);
        Pedido pedido = pedidoRepository.salvarPedido(PedidoHelper.buildPedido());
        assertNotNull(pedido);
        verify(pedidoRepositoryJpa, times(1)).save(any(PedidoEntity.class));
    }
    @Test
    void quandoBuscoTodosOsPedidos_entaoDeveBuscarTodosOsPedidosNaBase(){
        PedidoEntity pedidoEntity = PedidoHelper.buildPedidoEntity();
        when(pedidoRepositoryJpa.findAll()).thenReturn(List.of(pedidoEntity));
        List<Pedido> pedido = pedidoRepository.buscarTodosPedidos();
        assertNotNull(pedido);
        verify(pedidoRepositoryJpa, times(1)).findAll();
    }

    @Test
    void quandoBuscoUmPedidoPorId_entaoDeveBuscarOPedidoNaBase(){
        PedidoEntity pedidoEntity = PedidoHelper.buildPedidoEntity();
        when(pedidoRepositoryJpa.findById(anyString())).thenReturn(java.util.Optional.of(pedidoEntity));
        var pedido = pedidoRepository.buscarPedidoPorId("1");
        assertTrue(pedido.isPresent());
        verify(pedidoRepositoryJpa, times(1)).findById(anyString());
    }

    @Test
    void quandoBuscoFilaDePedidos_entaoDeveBuscarFilaDePedidosNaBase(){
        PedidoEntity pedidoEntityPronto = PedidoHelper.buildPedidoEntity();
        pedidoEntityPronto.setStatus("Pronto");
        PedidoEntity pedidoEntityPreparação = PedidoHelper.buildPedidoEntity();
        pedidoEntityPreparação.setStatus("Em preparação");
        PedidoEntity pedidoEntityRecebido = PedidoHelper.buildPedidoEntity();
        pedidoEntityRecebido.setStatus("Recebido");
        when(pedidoRepositoryJpa.findByStatusIn(anyList())).thenReturn(List.of(pedidoEntityPronto, pedidoEntityPreparação, pedidoEntityRecebido));
        List<Pedido> pedido = pedidoRepository.buscarFilaPedidos(List.of("Recebido", "Em preparação", "Pronto"));
        assertNotNull(pedido);
        verify(pedidoRepositoryJpa, times(1)).findByStatusIn(anyList());
    }

}
