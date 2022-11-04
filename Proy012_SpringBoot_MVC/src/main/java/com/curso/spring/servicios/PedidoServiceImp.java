package com.curso.spring.servicios;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.repositorios.PedidoJPARepository;
import com.curso.spring.repositorios.PedidoRepositoryImp;

@Service
@Transactional(propagation = Propagation.REQUIRED)
//por defecto esta configurado que sea singleton  ----> es unica para toda la app
public class PedidoServiceImp implements PedidoService {

	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);

//	@Autowired
//	@Qualifier("pedidoRepo")
//	private PedidoRepository repo;

	@Autowired
	private PedidoJPARepository repoJPA;

	public PedidoServiceImp() {
		log.info("... Instanciando PedidosServiceImp ...");
		log.info("Valor de repo " + repoJPA);
	}

	@PostConstruct
	public void init() {
		log.info("... estamos en el postconstruct de PedidosServiceImp ...");
		log.info("Ahora el valor de repo es " + repoJPA);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Pedido generarPedido(Pedido p) {
		// begin transaction

		log.info("Gestiono un pedido");
		// repo.add(p);
		
		return repoJPA.save(p);
		
		// commit or rollback
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Pedido> getPedidos(String user) {

		if (user == null) {
			// return repo.getAll();
			return repoJPA.findAll();
		} else {
			// return repo.getPedidosbyUser(user);
			Pedido pFiltro = new Pedido();
			pFiltro.setUser(user);
			return repoJPA.findByUser(user);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> getPedido(Integer id) {
		log.info("el id del pedido es " + id);
		return repoJPA.findById(id);
		//return repoJPA.getReferenceById(id);
	}

	@Override
	public void detelteById(Integer Id) {
		repoJPA.deleteById(Id);
	}

}
