package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Order;
import com.curso.jpa.entidades.Record;

public class PruebaOneToMany {

	public static void main(String[] args) {
		// 1. Crear la factoria de EM
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");

		// 2. Crear un EM
		EntityManager em = factory.createEntityManager();
		
		//crear un pedido para el cliente de id
//		
//		Order pedido = new Order();
//		pedido.setDescripcion("Urgencia");
//		Record rec = new Record();
//		rec.setName("REC_IMPORTATE");
//		
//		
//
//		// 3. transaccion
//
//		em.getTransaction().begin();
//		
//		em.persist(rec);
//		Customer cliente1 =  new Customer(7, "Pepino", rec);
//		em.persist(cliente1);
//		pedido.setCliente(cliente1);
//		em.persist(pedido);
//		
//		em.getTransaction().commit();
		
		Order pedidoEncontrado = em.find(Order.class, 4L); 
		
		System.out.printf("El pedido de id %d lo ha pedido el cliente %s%n", pedidoEncontrado.getOrderId(),
				pedidoEncontrado.getCliente().getCustomerName());
		
		System.out.println("....................................");
		System.out.println("..... Buscamos al cliente Pepino");
		Customer pepino = em.find(Customer.class, 7);
		System.out.println("El cliente " + pepino.getCustomerName() + " tiene los siguientes pedidos: ");
		for(Order or : pepino.getPedidos()) {
			System.out.println(or.getDescripcion());
		}

	}

}
