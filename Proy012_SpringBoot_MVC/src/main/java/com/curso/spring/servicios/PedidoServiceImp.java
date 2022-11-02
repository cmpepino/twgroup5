package com.curso.spring.servicios;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.repositorios.PedidoRepository;
import com.curso.spring.repositorios.PedidoRepositoryImp;

@Service
//@Lazy
//por defecto esta configurado que sea singleton  ----> es unica para toda la app
public class PedidoServiceImp implements PedidoService {

	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);

	@Autowired
	@Qualifier("pedidoRepo")
	private PedidoRepository repo;

	public PedidoServiceImp() {
		log.info("... Instanciando PedidosServiceImp ...");
		log.info("Valor de repo " + repo);
	}

	@PostConstruct
	public void init() {
		log.info("... estamos en el postconstruct de PedidosServiceImp ...");
		log.info("Ahora el valor de repo es " + repo);
	}

	@Override
	public void generarPedido(Pedido p) {

		log.info("Gestiono un pedido");
		repo.add(p);

	}

	@Override
	public Collection<Pedido> getPedidos(String user) {
		// TODO Auto-generated method stub
		return repo.getPedidosbyUser(user);
	}

}
