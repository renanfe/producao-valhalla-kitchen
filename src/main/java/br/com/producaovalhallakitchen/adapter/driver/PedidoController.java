package br.com.producaovalhallakitchen.adapter.driver;

import br.com.producaovalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.producaovalhallakitchen.core.applications.services.PedidoService;
import br.com.producaovalhallakitchen.core.domain.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodosPedidos() {
        return ResponseEntity.ok(pedidoService.buscarTodosPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable String id) {
        return pedidoService.buscarPedidoPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoForm pedidoForm, UriComponentsBuilder uriBuilder) {
        Pedido pedido = pedidoService.criarPedido(pedidoForm);
        String novaUri = uriBuilder.path("/{id}").buildAndExpand(pedido.getId()).toUriString();
        return ResponseEntity.created(UriComponentsBuilder.fromUriString(novaUri).build().toUri()).body(pedido);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedido> alterarStatusPedido(@PathVariable String id) {
        return pedidoService.alterarStatusPedido(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/fila")
    public ResponseEntity<List<Pedido>> buscarFilaPedido() {
        return ResponseEntity.ok(pedidoService.consultarFila());
    }

}
