package com.curso.spring.repositorios;

import java.util.ArrayList;
import java.util.Collection;

import com.curso.spring.entidades.Pedido;

public interface PedidoRepository {
	
	void add(Pedido pedido);

	Collection<Pedido> getPedidosbyUser(String user);
	
	
}
