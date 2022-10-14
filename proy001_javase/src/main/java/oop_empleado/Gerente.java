package oop_empleado;

import java.util.Date;

public class Gerente extends Empleado {
	// atributos
	private String Departamento;

	// CONSTRUCTORES

//	public Gerente(String nombre, double salario, Date fechaNacimiento, String departamento) {
//		super(nombre, salario, fechaNacimiento);
//		Departamento = departamento;
//	}
//	public Gerente(String nombre, String departamento) {
//		super(nombre);
//		Departamento = departamento;
//	}
//	public Gerente(String nombre, double salario, String departamento) {
//		super(nombre, salario);
//		Departamento = departamento;
//	}

	// METODOS
	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

	public String getDepartamento() {
		return Departamento;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails() + "Su departamento es " + Departamento + "\n";
	}
	
	public static void saluda() {
		System.out.println("Hola, soy un gerente...");
	}

}
