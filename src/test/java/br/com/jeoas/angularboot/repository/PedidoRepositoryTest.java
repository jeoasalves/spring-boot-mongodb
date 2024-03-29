package br.com.jeoas.angularboot.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jeoas.angularboot.document.Credenciamento;
import br.com.jeoas.angularboot.document.Pedido;
import br.com.jeoas.angularboot.helper.PedidoHelperTest;
import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@DataMongoTest
@Slf4j
public class PedidoRepositoryTest {

	@Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
	private PedidoRepository pedidoRepository;
    
	@Test
	public void salvarPedidoComSucesso() {
		Pedido pedido = new Pedido(PedidoHelperTest.codigo(),"REFUND", new Credenciamento(PedidoHelperTest.codigo()));
	
		mongoTemplate.save(pedido);

		log.info("Novo Pedido - Codigo Pedido: [{}], Codigo Credenciamento: [{}]", pedido.getCodigoPedido(), pedido.getCredenciamento().getCodigo());
		
		Pedido pedidoBanco = pedidoRepository.findByCodigoPedido(pedido.getCodigoPedido());	
		assertEquals(pedido.getCredenciamento().getCodigo(), pedidoBanco.getCredenciamento().getCodigo());
	}
	
}
