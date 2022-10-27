package com.curso.jpa.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.jpa.entidades.Trabajo;

public class PruebaTrabajoJPA {

	public static void main(String[] args) {
		
		//1. Crear una factoria de EntityManager                           persistence unit name
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		
		//2. Obtener un entity Manager
		//		que conecta con HR de ORACLE y mapea clases entidad
		EntityManager em = factory.createEntityManager();
		
		//3.Obtener el trabajo con el id "AD_VP"
		Trabajo t = em.find(Trabajo.class, "AD_VP");
		System.out.println(t);
		
		/* esto se hace una sola vez pues si no da error
		//4. crear un nuevo trabajo
		Trabajo tNuevo = new Trabajo("BE_OL","TAREAS SUPER DIFICILES", 33000.0,53000.0);
		
		//inicia una nueva transaccion
		em.getTransaction().begin();
		
		em.persist(tNuevo);//insertar
		
		//obtiene la transaccion y la confirma
		em.getTransaction().commit();
		
		*/
		//5.Modificacion
		//para lograr esto primero se debe sincronizar el dato de la base de datos con la variable del proyecto
		
		Trabajo tnuevoModificado = new Trabajo("BE_OL","TAREAS SUPER DIFICILES DE VERDAD", 33000.0,53000.0);
		
		//Modo 1 -> modificar despues de un find
		
		try {
			//---------Inicio del proceso transaccional
			em.getTransaction().begin();
			
			Trabajo tDesdeBD = em.find(Trabajo.class, tnuevoModificado.getId());
			//tDesdeBD -> ESTA SINCRONIZADO CON EL DATO QUE TIENE EL ID DEL tnuevoModificado
			tDesdeBD.setTituloTrabajo(tnuevoModificado.getTituloTrabajo());
			
			em.getTransaction().commit();
			//--------fin del proceso transaccional
		} catch (Exception e) {
			
			em.getTransaction().rollback();
		}
		
		//Modo 2 -> usando el metodo em.merge
		Trabajo otraVezTrabajModifi = new Trabajo("BE_OL","TAREAS SUPER DIFICILES DE VERDA", 38000.0,65000.0);
		
		em.getTransaction().begin();
		System.out.println("... antes del merge");
		Trabajo trabajoEnBD = em.merge(otraVezTrabajModifi);//coge la primaryKey la busca en la bd, la pasa a RAM, 
															//hace la mezcla de datos y solo en el commit hace el cambio
		System.out.println("... despues del merge");
		otraVezTrabajModifi.setTituloTrabajo("ksafsaklfhksfhs");//no esta attached contra la base de datos
		
		trabajoEnBD.setTituloTrabajo("este si esta attached");// esta variable si esta sincronizado con la basae de datos
		
		System.out.println("... antes del commit");
		em.getTransaction().commit();// -> hace la actualizacion
		System.out.println("... despues del commit");
		
		
		//6. Borrar
		em.getTransaction().begin();
		
		Trabajo tBorrar = new Trabajo();
		tBorrar.setId("BE_OL");				//NO ESTA SINCRONIZADO.
				
		//find del objeto y luego un remove
		Trabajo tBD = em.find(Trabajo.class,tBorrar.getId());
		
		
		em.remove(tBD);
		
		em.getTransaction().commit();
		
		
		//7. Consulta JPAQUERY
		
		Query query = em.createQuery("SELECT t FROM Trabajo t");
		
		List<Trabajo> lista = query.getResultList();
		System.out.println("...lista de trabajo");
		for(Trabajo trabajo : lista) {
			System.out.println(trabajo);
		}
		
	}

}
