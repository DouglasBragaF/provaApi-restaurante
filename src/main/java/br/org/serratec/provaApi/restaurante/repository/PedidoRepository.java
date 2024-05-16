package br.org.serratec.provaApi.restaurante.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.provaApi.restaurante.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	List<Pedido> findByNomeClienteContaining(String nomeCliente);
	
	List<Pedido> findByNomePratoContaining(String nomePrato);
	
	List<Pedido> findByDataPedidoBetween(LocalDateTime startDate, LocalDateTime endDate);
}
