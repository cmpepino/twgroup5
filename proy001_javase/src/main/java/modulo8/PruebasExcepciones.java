package modulo8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PruebasExcepciones {
	public static void main(String[] args) {
		int resultado = doble("2");
		System.out.printf(" el doble de %d es %d %n", 2, resultado);
		
	}
	
	public static int doble(String numero) {
		//validar q el numero es valido
		
		
		//la clase wrapper Integer tiene un metodo parseInt que
		//convierte un String en Int
		//si no lanza una excepcion
		int numeroInicial = 0;
		try {
			/*
			 * este codigo es suceptible de lanzar 
			 * NumberFormatException u otras
			 */
			numeroInicial = Integer.parseInt(numero);
			numeroInicial *= 2;
			
		}catch(NumberFormatException e) {
			
			System.out.println("No se puede calcular el doble");
		}catch(Exception e) {
			System.out.println("Error desconocido");
		}
		
		//Calculo del doble
		return numeroInicial;
	}
		
		public static void guardarResultado(String nombreFichero, int resultado) {
			
			//import java.io*
			File f = new File(nombreFichero);
			File f2 = new File("parametros.txt");
			try {
				
				f.createNewFile(); //lanza un IOException
				FileReader fr = new FileReader(f2); //lanza FileNotFoundException
				
			}catch(FileNotFoundException e){
				System.out.println("el fuchero parametros.txt no existe");
				return;
			}catch(IOException e) {
				System.out.println("No puedo crear el fichero de salida");
//				e.printStackTrace();
			}catch(Exception e) {
				System.out.println("error desconocido " + e.getMessage());
			}finally {
				System.out.println("Siempre me ejecuto. aun ejecutando antes un return");
			}
		}
	
	

}
