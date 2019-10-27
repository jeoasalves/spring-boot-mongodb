package br.com.jeoas.angularboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.jeoas.angularboot.document.Pedido;
import br.com.jeoas.angularboot.exception.PedidoNaoEncontradoException;
import br.com.jeoas.angularboot.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public Page<Pedido> listar(int page, 
			  int size) {
		return pedidoRepository.findAll(PageRequest.of(page, size));
	}

	public Pedido consultar(String codigoPedido) throws PedidoNaoEncontradoException {
		Pedido pedido = pedidoRepository.findByCodigoPedido(codigoPedido);

		if (pedido != null) {
			return pedido;
		}

		throw new PedidoNaoEncontradoException(codigoPedido);
	}

	public Pedido salvar(Pedido pedido) {
		pedido = pedidoRepository.save(pedido);

		return pedido;
	}

	public void remover(String codigoPedido) throws PedidoNaoEncontradoException {
		Pedido pedido = pedidoRepository.findByCodigoPedido(codigoPedido);
		if (pedido != null) {
			pedidoRepository.deleteById(pedido.getId());
		} else {
			throw new PedidoNaoEncontradoException(codigoPedido); 
		}
	}

	public Pedido atualizar(Pedido pedido) throws PedidoNaoEncontradoException {
		Pedido pedidoBanco = pedidoRepository.findByCodigoPedido(pedido.getCodigoPedido());

		if (pedidoBanco != null) {
			pedidoBanco.setSituacao(pedido.getSituacao());
			pedidoBanco = pedidoRepository.save(pedidoBanco);

			return pedidoBanco;
		}

		throw new PedidoNaoEncontradoException(pedido.getCodigoPedido());
	}

}
