package com.curso.mercado.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Producto_JPA_DAO<Producto> implements GenericDAO<Producto> {
	
	
	private static EntityManagerFactory factory;
	private static EntityManager em;
	
	static {
		factory = Persistence.createEntityManagerFactory("OracleHRPU");
		em = factory.createEntityManager();
	}

	@Override
	public void add(Producto entidad) {

		//Inicio del contexto transaccional
		em.getTransaction().begin();
		
		//Adicionar un producto
		em.persist(entidad);
				
		//Fin de la transaccion
		em.getTransaction().commit();
		
	}

	@Override
	public List<Producto> getAll() {
		//creacion de la consulta
		//Nativa
		Query consulta = em.createQuery("SELECT d FROM Producto d");
		return consulta.getResultList();
		
	}

	@Override
	public Producto getByID(int id) {
		// Aun esta en produccion
//		Query consulta = em.createQuery("SELECT d FROM Producto d WHERE d.idProducto = :id");
//		consulta.setParameter("idProducto", id);
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

}
