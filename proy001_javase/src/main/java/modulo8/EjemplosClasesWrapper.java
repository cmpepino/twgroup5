package modulo8;

public class EjemplosClasesWrapper {
	public static void main(String[] args) {
	
		int num = 2;
		Integer num2 = new Integer(2);
		Integer num3 = 2;	//Internamente new Integer(2)
		
		int num4 = num3; //llama al metodo .intValue que realiza una conversion
		
		//comparacion
		Integer n1 = 1;
		Integer n2 = 1;
		Integer n3 = new Integer(1);
		System.out.println("n1==n2"+(n1==n2));//true
		System.out.println("n1==n2"+(n1==n3));//false
		
		Integer n4 = 128;
		System.out.println("n1==n2"+(n1==n2));//false
		Integer n5 = 128;
		// == -> comparacion del valor en tipos primitivos y de la direccion en tipos no primitivos
		
		/*
		 * porque al igual q los String existe un pool de numeros, 
		 * o sea si se compara dos integer que ambos presetan un numero menor a 128 van a dar igual 
		 * pues para ahorrar memoria utilizaran la direccion de memoria que se encuentra
		 */
		
	}

}
