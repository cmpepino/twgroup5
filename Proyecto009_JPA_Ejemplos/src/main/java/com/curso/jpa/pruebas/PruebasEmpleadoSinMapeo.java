package com.curso.jpa.pruebas;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Departamento;
import com.curso.jpa.entidades.Empleado;
import com.curso.jpa.entidades.EmpleadoSinMapeos;

public class PruebasEmpleadoSinMapeo {

	public static void main(String[] args) {


		//1. Crear la factoria de EM
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		
		//2. Crear un EM
		EntityManager em = factory.createEntityManager();
		
		//3. Crear una transaccion
		EmpleadoSinMapeos newEmpleado = new EmpleadoSinMapeos();
		newEmpleado.setNombre("Zuce2");
		newEmpleado.setApellidos("Guedes2");
		newEmpleado.setEmail("zguedes2");
		newEmpleado.setSalario(50000.00);
		newEmpleado.setFechaContratacion(new Date());
		
		Departamento depa = new Departamento();
		depa.setId(10);
		depa.setNombreDepartamento("Investigacones");
		depa.setIdLocalidad(11);
		newEmpleado.setDepartamento(depa);
		//newEmpleado.setIdTrabajo("ST_MAN");
		
		
				
		//4. Crear un empleado nuevo
		em.getTransaction().begin();
		try {
			//em.persist(newEmpleado);
			//em.merge(EmpleadoSinMapeos.class)
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		
		
			
		//5. persistirlo en BD
		
		
		//6. confirmar transaccion si ok; rollback si fallo.
	}

}
