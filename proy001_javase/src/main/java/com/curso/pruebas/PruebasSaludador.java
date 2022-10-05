package com.curso.pruebas;
import java.util.*;

import com.curso.varios.Saludador;

//java carga las clases de los paquetes a medida que los vaya empleando en el codigo.
//el asterisco te hace refernecia a todas 

public class PruebasSaludador {

	public static void main(String[] args) {
		// uso de la clase saludador
		int numeroCamiones = 2;
		Date fecha =new Date();
		
		//1. Crear un obj saludador
		// crear un objeto de la clase, instanciar un objeto de la clase
		// s1 variable de referencia que apunta a objeto de tipo Saludador
		//com.curso.varios.Saludador s;
		Saludador s1 = new Saludador();
		//via 2
		/*
		 * importar el paquete donde esta la variable
		 * import com.curso.varios.saludador;
		 * despues en el main solo se hace la referencia como = saludador s1
		 */
		
		//2. Pedir saludar pasando nombre -> muestra "hola" + nombre
		
		//autocompletar syso +ctrol+space
		System.out.println(s1.saluda("Begoña Olea"));
		
		//3. Pedir saludo
		System.out.println(s1.saluda());
		
		//4. Crear un saludador en el que indique el saludo
		Saludador s2 = new Saludador("Buenos dias");
		System.out.println(s2.saluda());

	}

}
