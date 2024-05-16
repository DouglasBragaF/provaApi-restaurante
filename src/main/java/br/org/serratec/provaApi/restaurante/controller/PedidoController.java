package br.org.serratec.provaApi.restaurante.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.provaApi.restaurante.dto.PedidoDto;
import br.org.serratec.provaApi.restaurante.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
    private PedidoService servico;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listar() {
        List<PedidoDto> pedidos = servico.listarTodos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscar(@PathVariable Long id) {
        Optional<PedidoDto> pedido = servico.listarPorId(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDto inserir(@Valid @RequestBody PedidoDto pedido) {
        return servico.salvarPedido(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @Valid @RequestBody PedidoDto pedidoAlterado) {
        Optional<PedidoDto> pedido = servico.atualizarPedido(id, pedidoAlterado);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!servico.excluirPedido(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/cliente")
    public ResponseEntity<List<PedidoDto>> buscarPorNomeCliente(@RequestParam String nomeCliente) {
        List<PedidoDto> pedidos = servico.buscarPorNomeCliente(nomeCliente);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }
    
    @GetMapping("/prato")
    public ResponseEntity<List<PedidoDto>> buscarPorNomePrato(@RequestParam String nomePrato) {
        List<PedidoDto> pedidos = servico.buscarPorNomePrato(nomePrato);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }
    
    @GetMapping("/data")
    public ResponseEntity<List<PedidoDto>> buscarPorDataPedido(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<PedidoDto> pedidos = servico.buscarPorDataPedido(startDate, endDate);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }
}
