package oop_empleado;

import java.util.Date;

public class Empleado {
	
	//Ctes	
	private static final double SALARIO_BASE = 15000.0;
	
	//atributos
	private String nombre;
	private double salario;
	private Date fechaNacimiento;
	
	//CONSTRUCTORES	
//	public Empleado(String nombre, double salario, Date fechaNacimiento) {
//		super();
//		this.nombre = nombre;
//		this.salario = salario;
//		this.fechaNacimiento = fechaNacimiento;
//	}
//	public Empleado(String nombre, double salario) {
//		this(nombre,salario,null);
//	}
//	public Empleado(String nombre, Date fechaNacimiento) {
//		this(nombre,SALARIO_BASE,fechaNacimiento);
//	}
//	public Empleado(String nombre) {
//		this(nombre,SALARIO_BASE);//llama al constructor que cumpla con los argumentos que se le esta pasando
//	}							  // o sea cuando se le llama salta al constructor que solo se le pasa nombre y salario

//public Empleado() {
//		super();
//	}
	
	//metodos
	
	public String getNombre() {
		return nombre;
	}

	public double getSalario() {
		return salario;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDetails() {
		return "El nombre del empleado es " + nombre + ".\n"
				+ "Su salario es " + salario + ".\n"
						+ "Su fecha de nacimiento es " + fechaNacimiento + ".\n";
	}

	public static void saluda() {
		System.out.println("Hola, soy un empleado sin mas ...");
	}
	

}
