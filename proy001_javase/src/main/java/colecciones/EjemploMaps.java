package colecciones;

import java.util.*;

public class EjemploMaps {
	
	public static void main(String[] args) {
		
		//Map <<Interface>>
		/*
		 * solo trabajan con objetos 
		 * key => unico, no debe ser dublicados   ---> Puede ser cualquier Objeto
		 * value => permite duplicados            ---> Puede ser cualquier Objeto
		 */
		
		Map map;
		//map.put(key,value)
		//map.get(key):value
		
		//key no duplicado -value
		map = new HashMap();
		
		Map<Integer, Punto> figura = new HashMap();
/*				^       ^		
 * 				|		|
 * 		  los guarda en |
 * 		   colecciones  |
 * 			tipo set    |
 *                   Los guarda en colecciones de tipo collections
 */
		
		figura.put(1, new Punto(0,0));
		figura.put(10, new Punto(4,6));
		figura.put(10, new Punto(8,8));
		System.out.println(figura.get(10));
		
		//figura.remove(1);
		System.out.println(figura.get(1));
		
		figura.put(10, new Punto(4,6));
		figura.put(2, new Punto(6,6));
		figura.put(7, new Punto(6,6));
		
		
		Collection<Punto> valores = figura.values();
		Set<Integer> claves = figura.keySet();
				
		System.out.println("... recorre valores");
		for(Punto p:valores) System.out.println(p);
		
		System.out.println("... recorre las claves y valores");
		for(Integer clave : claves) {
			System.out.println(clave + " " + figura.get(clave));
		}
		
		//---------------------------------------------
		
		
		//HashMap 		- recorro la coleccion a traves key no orden
		//TreeMap 		- recorro la coleccion a traves key por orden de comparable/comparator
		//LinkedHashMap 		- recorro la coleccion a traves key por el orden de insercion
		
		//Collections.
		
		//Arrays.
		
		
	}

}
