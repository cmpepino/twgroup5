package colecciones;

import java.util.*;

public class EjColecciones {

	public static void main(String[] args) {
		// Clase q permite tener una coleccion de Objetos ----------> pertenece al paquete java.util
		//Caracterristicas:
		//		1. Tamaño ilimitado
		//		2. Solo admiten objetos
		//		3. Existen muchos tipos de colecciones
		
		/*
		 * Collection es un interface
		 * 		 set(Interface) y List(Interface)
		 * 
		 * Otra coleccion es Map(Interface)(key - value)
		 */
		
		/*
		 * Collection
		 * 		Set               -----------> No permiten duplicados
		 * 			HashSet       ----------------------------------->No ordenados
		 * 			LinkedHashSet ----------------------------------->Ordenados por el orden de insercion
		 * 			TreeSet       ----------------------------------->orden natural(comparable/comparator)
		 * 		List              -----------> Permite Duplicados // indexado
		 * 			ArrayList     ----------------------------------->
		 * 			LinkedList    ----------------------------------->
		 * 			Queu          ----------------------------------->
		 */
		
		Collection c;
		
		Set x;
		
		Set s = new HashSet();
		s.add("zapato");
		s.add("Avion");
		s.add(3);
		s.add(new Integer(2));
		
		s.remove("Avion");
		
		for(Object o:s) {
			System.out.println(o);
		}
		
		Set <String> nombres = new LinkedHashSet();
		nombres.add("Perico");
		nombres.add("Carlos");
		nombres.add("Mario");
		nombres.add("Silvia");
		nombres.add("Begoña");
		boolean añadido = nombres.add("Begoña");
		
		if(!añadido)
		
		
		
		System.out.println("............");
		
		Punto p1 = new Punto(3,2);
		Punto p2 = new Punto(1,1);
		Punto p3 = new Punto(1,5);
		Punto p4 = new Punto(1,5); //repite
		
//		Set <Punto> fig = new HashSet();
		Set <Punto> fig = new TreeSet<Punto>();
		fig.add(p1);
		fig.add(p2);
		fig.add(p3);
		fig.add(p4);
		
		for(Punto p : fig) {
			System.out.println(p);
		}
		
		//Comparator
		//Set <String> apellidos = new TreeSet();
		Set <String> apellidos = new TreeSet(new ComparadorStringOrdenInverso());
		nombres.add("Alonso");
		nombres.add("Olea");
		nombres.add("Rosales");
		nombres.add("Perez");
		nombres.add("Rodriguez");
		for(String n : apellidos) {
			System.out.println(n.toUpperCase());
		}
		
		//Colecciones tipo List
		List<String> paises = new ArrayList<String>();
		paises.add("China");
		paises.add("Egipto");
		paises.add("Italia");
		paises.add("Peru");
		paises.add("Peru");
		paises.add("Austria");
		
		paises.add(1,"España");
		System.out.println("pais en 0 " + paises.get(0));
		
		System.out.println("........ Listado de paises");
		for(String p : paises) {
			System.out.println(p);
		}
		
		Collections.sort(paises);  // es una coleccion de String 
									//Ordena tomando la definicion de comparable para el tipo String
		
		System.out.println(".......Listado de paises ordenados");
		for(String p : paises) {
			System.out.println(p);
		}
		
		System.out.println(".......Listado de paises inversamente ordenados");
		Collections.sort(paises, new ComparadorStringOrdenInverso());
		for(String p : paises) {
			System.out.println(p);
		}
		
		LinkedList <String> lista = new LinkedList<String>();
		lista.addFirst("Hola");
		lista.add("holax2");
		lista.addLast("Adios");
		
		//Colas
		PriorityQueue <Integer> cola = new PriorityQueue<Integer>();
		
		cola.add(39);
		cola.add(1);
		cola.add(123);
		cola.add(3);
		cola.add(26);
		cola.add(31);
		cola.add(267);
		for(Integer i : cola) System.out.println(i);
		Integer trato = cola.peek();
		System.out.println("Me entrega ... " + trato);
		System.out.println("........................");	
		System.out.println("Me entrega ... " + cola.peek());
		System.out.println("Me entrega ... " + cola.peek());
		System.out.println("Me entrega ... " + cola.peek());
		System.out.println("Me entrega ... " + cola.peek());
		
		System.out.println("........................");
		System.out.println("Me entrega ... " + cola.poll());
		System.out.println("Me entrega ... " + cola.poll());
		System.out.println("Me entrega ... " + cola.poll());
		
		System.out.println("........................");
		for(Integer i : cola) System.out.println(i);
		
		
		

	}

}
