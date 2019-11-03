package br.com.jeoas.angularboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.jeoas.angularboot.document.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

    public Pedido findByCodigoPedido(String codigoPedido);
    public List<Pedido> findBySituacao(String situacao);

}