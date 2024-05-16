package br.org.serratec.provaApi.restaurante.model;

import java.time.LocalDateTime;

import br.org.serratec.provaApi.restaurante.dto.PedidoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "contato_cliente")
    private String contatoCliente;

    @Column(name = "nome_prato")
    private String nomePrato;

    @Column(name = "valor_prato")
    private Double valorPrato;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

	public Pedido() {
		super();
	}

	public Pedido(Long idPedido, String nomeCliente, String contatoCliente, String nomePrato, Double valorPrato,
			LocalDateTime dataPedido) {
		super();
		this.idPedido = idPedido;
		this.nomeCliente = nomeCliente;
		this.contatoCliente = contatoCliente;
		this.nomePrato = nomePrato;
		this.valorPrato = valorPrato;
		this.dataPedido = dataPedido;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getContatoCliente() {
		return contatoCliente;
	}

	public void setContatoCliente(String contatoCliente) {
		this.contatoCliente = contatoCliente;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public Double getValorPrato() {
		return valorPrato;
	}

	public void setValorPrato(Double valorPrato) {
		this.valorPrato = valorPrato;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
    
	public PedidoDto toDto() {
        return new PedidoDto(
            this.idPedido,
            this.nomeCliente,
            this.contatoCliente,
            this.nomePrato,
            this.valorPrato,
            this.dataPedido
        );
    }
    
}
