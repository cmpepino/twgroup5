package com.curso.jpa.pruebas;

import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.*;

import com.curso.jpa.entidades.Departamento;
import com.curso.jpa.entidades.EmpleadoSinMapeos;

public class PruebasCriteria {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");

		// 2. Crear un EM
		EntityManager em = factory.createEntityManager();

		// 1.Usando Criteria Builder
		// Obtener todos los departamentos por localidad or Manager

		// condicion de localidad or manager opcional
		// Si no me pasas localiadd y manager devuelvo todos
		// si solo

		Integer idLocalidad = 1700;

		Integer idManager = 201;

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Departamento> cq = cb.createQuery(Departamento.class);
		// From
		Root<Departamento> departamento = cq.from(Departamento.class);

		// Condiciones
		
		Predicate condFinal = null;
		Predicate condLocalidad = null;
		Predicate condManager = null;

		if (idLocalidad != null && idManager != null) {

			condFinal = cb.or(cb.equal(departamento.get("idLocalidad"), idLocalidad),
							   cb.equal(departamento.get("idManager"), idManager));
			cq.where(condFinal);
			

		} else if (idLocalidad != null) {
			condLocalidad = cb.equal(departamento.get("idLocalidad"), idLocalidad);
			cq.where(condLocalidad);

		} else if (idManager != null) {
			condManager = cb.equal(departamento.get("idManager"), idManager);
			cq.where(condManager);
		}
		
		//Mostrar resultados
		Query qCriteria = em.createQuery(cq);
		List<Departamento> depa = qCriteria.getResultList();

		System.out.println(".... Los empleados ....");
		for (Departamento emp : depa) {
			System.out.println(emp);
		}

	}

}
