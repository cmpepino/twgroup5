package com.curso.spring.repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
@Qualifier("pedidoRepo")
//@Lazy		//Por default es eager
public class PedidoRepositoryImp implements PedidoRepository {

	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);

	private static Map<Integer, Pedido> pedidos = new HashMap<Integer, Pedido>();
	private static int id;

	static {
		pedidos.put(1, new Pedido(1, "Luis", "Television", new Date(), true));
		pedidos.put(2, new Pedido(2, "Luis", "Libro", new Date(), true));
		pedidos.put(3, new Pedido(3, "Maite", "Moto", new Date(), true));
		id = 3;

	}

	public PedidoRepositoryImp() {
		log.info("... Instanciado PedidoRepositoryImp...");
	}

	@Override
	public void add(Pedido pedido) {
		id++;
		pedido.setId(id);
		pedidos.put(id, pedido);
		log.info("Has grabado un pedido en la base de datos");

	}

	@Override
	public Collection<Pedido> getPedidosbyUser(String user) {
		Collection<Pedido> lista = new ArrayList<Pedido>();
		for (Pedido p : pedidos.values()) {
			if (p.getUser().equals(user)) {
				lista.add(p);
			}

		}
		log.info(lista.toString());
		return lista;
	}
	
	@Override
	public Collection<Pedido> getAll() {
		return pedidos.values();
	}
	
	@Override
	public Pedido getbyId(Integer id) {
		return pedidos.get(id);
	}

}
