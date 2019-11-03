package br.com.jeoas.angularboot.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 148221790490989004L;

	public PedidoNaoEncontradoException(String codigoPedido) {
		super("Pedido não foi encontrado. Código Pedido: [" + codigoPedido + "]");
	}
}
