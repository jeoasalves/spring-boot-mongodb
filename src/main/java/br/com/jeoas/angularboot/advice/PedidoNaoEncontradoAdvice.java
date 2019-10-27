package br.com.jeoas.angularboot.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.jeoas.angularboot.exception.PedidoNaoEncontradoException;

@ControllerAdvice
public class PedidoNaoEncontradoAdvice {

	@ResponseBody
	@ExceptionHandler(PedidoNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String clienteNaoEncontradoHandler(PedidoNaoEncontradoException ex) {
		return ex.getMessage();
	}

}
