package br.com.jeoas.angularboot.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jeoas.angularboot.document.Credenciamento;
import br.com.jeoas.angularboot.document.Pedido;
import br.com.jeoas.angularboot.helper.PedidoHelperTest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidoControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@TestConfiguration
	static class Config {
		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().basicAuthentication("", "");
		}
	}

	@Test
	public void testarConsultaPorCodigoPedidoComSucesso() {
		ResponseEntity<Pedido> resultado = restTemplate.getForEntity("/pedidos/v2/5050639782", Pedido.class);
		assertEquals(resultado.getBody().getCodigoPedido(), "5050639782");
	}

	@Test
	public void testarSalvarPedidoComSucesso() {
		ResponseEntity<Pedido> resultado = restTemplate.postForEntity("/pedidos",
				new Pedido(PedidoHelperTest.codigo(), "REFUND", new Credenciamento(PedidoHelperTest.codigo())), Pedido.class);
		assertEquals(resultado.getStatusCode(), HttpStatus.OK);
		assertNotNull(resultado.getBody().getCodigoPedido());
	}
}
