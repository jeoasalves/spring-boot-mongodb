package br.com.jeoas.angularboot.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "credenciamento")
@Document(collection = "pedidos")
public class Pedido {

	@Id
	private String id;
	
	@Include
	private String codigoPedido;
	private String situacao;
	
	private Credenciamento credenciamento;
	
	public Pedido(String codigoPedido, String situacao, Credenciamento credenciamento) {
		super();
		this.codigoPedido = codigoPedido;
		this.situacao = situacao;
		this.credenciamento = credenciamento;
	}

	public Pedido(String codigoPedido, String situacao) {
		super();
		this.codigoPedido = codigoPedido;
		this.situacao = situacao;
	}
	
	public Pedido(String codigoPedido) {
		super();
		this.codigoPedido = codigoPedido;
	}
	
}
