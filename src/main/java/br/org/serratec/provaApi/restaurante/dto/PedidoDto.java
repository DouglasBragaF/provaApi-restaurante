package br.org.serratec.provaApi.restaurante.dto;

import java.time.LocalDateTime;

import br.org.serratec.provaApi.restaurante.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoDto(
		Long idPedido,
        @NotBlank(message = "O nome do cliente deve ser preenchido!")
        String nomeCliente,
        @NotBlank(message = "O contato do cliente deve ser preenchido!")
        String contatoCliente,
        @NotBlank(message = "O nome do prato deve ser preenchido!")
        String nomePrato,
        @NotNull(message = "O valor do prato deve ser informado!")
        @Positive(message = "O valor do prato deve ser um valor positivo!")
        Double valorPrato,
        @NotNull(message = "A data do pedido deve ser informada!")
        LocalDateTime dataPedido) {
	
	public Pedido toEntity() {
        return new Pedido(this.idPedido, this.nomeCliente, this.contatoCliente, this.nomePrato, this.valorPrato, this.dataPedido);
    }
}
