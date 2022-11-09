package com.curso.spring.servicios;

import java.util.Collection;
import java.util.Optional;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.excepciones.PedidosException;

public interface PedidoService {
	
	Pedido generarPedido(Pedido p);
	Collection<Pedido> getPedidos(String user);
	Optional<Pedido> getPedido(Integer id);
	void detelteById(Integer Id) throws PedidosException;
	Pedido modificarPeddido(Pedido p);
	
	
}
