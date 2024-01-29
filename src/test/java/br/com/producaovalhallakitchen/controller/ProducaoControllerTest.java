package br.com.producaovalhallakitchen.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest() //Setar controlador
@ExtendWith(MockitoExtension.class)
public class ProducaoControllerTest {

    @Test
    public void quandoEuReceboUmPedido_entaoOPedidoDeveSerCadastrado(){
        Assert.fail("Teste não implementado");
    }
    @Test
    public void quandoSolicitoOPedido_entaoDevoRetornarOPedido(){
        Assert.fail("Teste não implementado");
    }
}
