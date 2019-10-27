package br.com.jeoas.angularboot.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "pedidos")
public class Pedido {

	@Id
	private String id;
	private String codigoPedido;
	private String situacao;
	
	//private Credenciamento credenciamento;
	private Credenciamento credenciamento;
	
	public Pedido() {
	}

	public Pedido(String id, String codigoPedido, String situacao, Credenciamento credenciamento) {
		super();
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.situacao = situacao;
		this.credenciamento = credenciamento;
	}
	
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
