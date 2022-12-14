package com.curso.spring.repositorios;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
@Qualifier("pedidoRepoJPA")
public class PedidoJPARepositoryImp implements PedidoRepository {
	
	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);

	@Override
	public void add(Pedido pedido) {
		log.info("... Grabar pedido con JPA ...");

	}

	@Override
	public Collection<Pedido> getPedidosbyUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<Pedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pedido getbyId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
