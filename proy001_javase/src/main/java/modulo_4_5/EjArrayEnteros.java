package modulo_4_5;

public class EjArrayEnteros {

	public static void main(String[] args) {

		int[] numeros; // declaracion de un array de tipos int
		numeros = new int[4]; // creo un array de enteros inicializados a 0

		// for mejorado
		/*
		 * parametros1 = variable que va a recorrer el array parametro2 = noombre del
		 * array que se quiere recorrer completo
		 */
		for (int n : numeros) {
			System.out.println(n);
		}

		numeros[0] = 7;
		for (int n : numeros) {
			System.out.println(n);
		}
		
		//declarar e inicializar
		int [] cantidades = {1,2,3,4,5,6};
		int [] c;
		c = new int[] {1,2,3,4};

	}

}
