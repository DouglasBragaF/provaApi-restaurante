package br.org.serratec.provaApi.restaurante.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.provaApi.restaurante.dto.PedidoDto;
import br.org.serratec.provaApi.restaurante.model.Pedido;
import br.org.serratec.provaApi.restaurante.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
    private PedidoRepository repositorio;

    public List<PedidoDto> listarTodos() {
        return repositorio.findAll().stream()
                .map(Pedido::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PedidoDto> listarPorId(Long id) {
        Optional<Pedido> pedido = repositorio.findById(id);
        return pedido.map(Pedido::toDto);
    }

    public PedidoDto salvarPedido(PedidoDto pedidoDto) {
        Pedido pedidoEntity = repositorio.save(pedidoDto.toEntity());
        return pedidoEntity.toDto();
    }

    public Optional<PedidoDto> atualizarPedido(Long id, PedidoDto pedidoDto) {
        if (repositorio.existsById(id)) {
            Pedido pedido = pedidoDto.toEntity();
            pedido.setIdPedido(id);
            repositorio.save(pedido);
            return Optional.of(pedido.toDto());
        }
        return Optional.empty();
    }

    public boolean excluirPedido(Long id) {
        if (!repositorio.existsById(id)) {
            return false;
        }
        repositorio.deleteById(id);
        return true;
    }
    
    public List<PedidoDto> buscarPorNomeCliente(String nomeCliente) {
        return repositorio.findByNomeClienteContaining(nomeCliente).stream()
                .map(Pedido::toDto)
                .collect(Collectors.toList());
    }
    
    public List<PedidoDto> buscarPorNomePrato(String nomePrato) {
        return repositorio.findByNomePratoContaining(nomePrato).stream()
                .map(Pedido::toDto)
                .collect(Collectors.toList());
    }
    
    public List<PedidoDto> buscarPorDataPedido(LocalDateTime startDate, LocalDateTime endDate) {
        return repositorio.findByDataPedidoBetween(startDate, endDate).stream()
                .map(Pedido::toDto)
                .collect(Collectors.toList());
    }
}
