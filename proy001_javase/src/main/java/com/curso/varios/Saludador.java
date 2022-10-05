package com.curso.varios;

/*
 *    JVM cargar la clase com.cursovarios.saludador
 */
public class Saludador {
	// atributos
	private String saludo = "Hola ";

	// constructores
	// si no se escribe nada el compilador lo hace por defecto de la siguiente
	// manera: public Saludador(){super();}
	public Saludador() {
		super();
		this.saludo = "Hola ";
	}
	
	public Saludador(String saludo) {
		//cuidado : en el constructor no se debe poner formatode salida
		this.saludo = saludo;
	}

	// metodos
	public String saluda(String nombreUsuario) {
		//return "Hola " + nombreUsuario;
		return this.saludo + nombreUsuario;
	}

	// sobrecargar el metodo
	public String saluda() {
		//return "Hola amigo";
		return this.saludo + " amigo";
	}
}
