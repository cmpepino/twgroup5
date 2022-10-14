package modulo6_equals;

public class PruebaEquals {
	
	public static void main(String[] args) {
		//comparacion entre tipos primitivos
		int a = 500;
		int b = 500;
		System.out.println("a==b " + ( a==b ));
		
		
		//Comparacion entre objetos
		Cliente c1 = new Cliente(1,"Laura");
		Cliente c2 = new Cliente(2,"Laura");
		System.out.println("c1==c2 " + ( c1==c2 ));
		
		/*
		 * la funcion equals()
		 */
		
		System.out.println("c1==c2 " + ( c1.equals(c2)));
		
	}
}
