package modulo6_equals;

public class EjEqualsString {

	public static void main(String[] args) {
		String s = "Hola";		//equivalente a decir => new String("hola")
		String p = "Hola";
		/*
		 * con la forma anterior, se crea un objeto String "HOLA" en el StringPool
		 * s y p apuntan al mismo objeto
		 */
		
		String x = new String("Hola");
		
		System.out.println("p == s " + (s==p)); //true
		System.out.println("x == s " + (s==x)); //false
		
		
		//String ==> es una clase inmutable.
		/*
		 * el objeto creado de la clase string no se modifica para nada
		 */
		
		String h = "Hola";
		h.toUpperCase();
		System.out.println(h);

	}

}
