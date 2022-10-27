package com.curso.jpa.pruebas;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.EmpleadoSinMapeos;
import com.curso.jpa.entidades.Record;

public class PruebaOneToOne {

	public static void main(String[] args) {

		// 1. Crear la factoria de EM
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");

		// 2. Crear un EM
		EntityManager em = factory.createEntityManager();

		// 3. transaccion

		em.getTransaction().begin();

		// crear un record
		// crear un cliente que tenga ese record
		// buscar el cliente que acabamos de crear
		// mostrar sus datos y los de su record

		Record rec = new Record();
		rec.setName("REC_UNO");
		em.persist(rec);

		Customer cliente = new Customer(null, "Luis Ramos", rec);
		em.persist(cliente);
		int id = cliente.getId();

		em.getTransaction().commit();

		System.out.println("Buscar el empleado cuya id es " + id);

		Customer cEncontrado = em.find(Customer.class, id);
		if (cEncontrado != null) {
			System.out.printf("El cliente %s tiene el record %s%n", cEncontrado.getCustomerName(),
					cEncontrado.getRecord().getName());
		} else {
			System.out.println("cliente no encontrado");
		}

	}

}
