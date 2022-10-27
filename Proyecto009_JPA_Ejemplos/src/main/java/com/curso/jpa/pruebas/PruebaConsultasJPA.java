package com.curso.jpa.pruebas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;


import com.curso.jpa.entidades.Departamento;
import com.curso.jpa.entidades.EmpleadoSinMapeos;

public class PruebaConsultasJPA {

	public static void main(String[] args) {

		// fin del main//1. Crear la factoria de EM
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");

		// 2. Crear un EM
		EntityManager em = factory.createEntityManager();

		// 3. Cosultas JPA

		// 3.1 Query Nativa(BD) --> select * from departments
		// 3.1(equivalente) ------> SELECT d FROM DEPARMENT d

		Query consulta = em.createQuery("SELECT d FROM Departamento d");
		List<Departamento> lista = consulta.getResultList();
		System.out.println("Lista de departamento sin manager");
		for (Departamento d2 : lista) {
			System.out.println(d2);
		}

		/*
		 * Modo 2 ----> utilizar el name queries (Nombre de la query creada y definida en la clase Departamento) 
		 * 												   |
		 */ //                                             V
		Query consulta2 = em.createNamedQuery("Departamento.findSinManager");
		List<Departamento> lista2 = consulta2.getResultList();
		System.out.println("Lista de departamento sin manager");
		for (Departamento d2 : lista2) {
			System.out.println(d2);
		}

		/*Modo 3 ------Query Nativa                    (Nombre de la tabla)
		 * 													    |
		 */// 													v
		Query consulta3 = em.createNativeQuery("SELECT * FROM DEPARTMENTS", Departamento.class);
		List<Departamento> lista3 = consulta3.getResultList();
		System.out.println("Lista de todos los departamentos");
		for (Departamento d2 : lista3) {
			System.out.println(d2);
		}

		// ejecutar una consulta con parametros
		Query qConParam = em.createNamedQuery("Departamento.findByManagerID");
		qConParam.setParameter("idManager", 108);

		List<Departamento> departamento108 = qConParam.getResultList();
		System.out.println("Los departamentos del manager 108 son: ");
		for (Departamento d2 : departamento108) {
			System.out.println(d2);
		}

		/*
		 * SELECT E.* FROM DEPARTMENTS D INNER JOIN EMPLOYEES E ON D.MANAGER.ID =
		 * E.EMPLOYEES WHERE D.LOCATION_ID = 1700;
		 */

		String consultaEmpleadoDptoLoc1700 = "SELECT e FROM EmpleadoSinMapeos e "
				+ "where e.departamento.idLocalidad = :idLoc";

		int idLocalidad = 1700;
		Query q = em.createQuery(consultaEmpleadoDptoLoc1700);
		q.setParameter("idLoc", idLocalidad);

		List<EmpleadoSinMapeos> listEmp = q.getResultList();

		System.out.println("... Lista de empleados depart localidad 1700 ....");

		for (EmpleadoSinMapeos e : listEmp) {
			System.out.println(e);
		}

		// Lo siguiente es para crear una query/consulta de forma dinamica.
		// Solo te mostrara los datos a partir de criterios elegidos por el usuario
		// Criteria
		// Pantalla Filtro busqueda/ lista resultado de la busqueda

		// filtro Nombre
		// filtro ID_TRABAJO
		// ...

		String nombre = "Steven";
		String apellidos = null;//"Perez";
		Integer idJob = null;
		Double salario = 10.0;

		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Entidades quiero recuperar
		CriteriaQuery<EmpleadoSinMapeos> cq = cb.createQuery(EmpleadoSinMapeos.class);

		// From
		Root<EmpleadoSinMapeos> empleado = cq.from(EmpleadoSinMapeos.class);
		
		
		// Criterio de busqueda
		
		//Objeto Predicate que va montando las condiciones del where
		Predicate miWhere;
		List<Predicate> condiciones = new ArrayList<>();
		
		if (nombre != null) {
			condiciones.add(cb.equal(empleado.get("nombre"), nombre));
		}
		if (apellidos != null) {
			condiciones.add(cb.equal(empleado.get("apellidos"), apellidos));
		}
		if (salario != null) {
			condiciones.add(cb.greaterThan(empleado.get("salario"), salario));
		}
		
		//	OR JOB_ID = 'AD_ASST'
		Predicate andVarios =cb.and(condiciones.toArray(new Predicate[0]));
		Predicate orJob = cb.equal(empleado.get("idTrabajo"), "AD_ASST");
		
		Predicate whereFinal = cb.or(andVarios, orJob);
		cq.where(whereFinal);
		
		/*
		//where
		if(condiciones.size() > 0) {
			Predicate [] condicionesFinal = new Predicate[condiciones.size()];
			condiciones.toArray(condicionesFinal);
			cq.where(condicionesFinal);
			
			/*Lo siguiente hace lo mismo q arriba.
			 * cq.where(condiciones.toArray(new Predicate[0]));
			 */
			
		//}
		
		
		// I. Si me has pasado un nombre de empleado lo añado en el where
//		if (nombre != null) {
//			cq.where(cb.equal(empleado.get("nombre"), nombre));
//		}
//		if (apellidos != null) {
//			cq.where(cb.equal(empleado.get("apellidos"), apellidos));
//		}

		// Ejecutar consulta
		Query qCriteria = em.createQuery(cq);
		List<EmpleadoSinMapeos> listaEmpleado = qCriteria.getResultList();

		System.out.println(".... Los empleados ....");
		for (EmpleadoSinMapeos emp : listaEmpleado) {
			System.out.printf(" %s %s %n", emp.getNombre(), emp.getApellidos());
		}
		
		//ORDER BY  -> ordenar la tabla por el argumento que le pasas

	}
}
