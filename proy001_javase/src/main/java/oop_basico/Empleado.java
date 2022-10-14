package oop_basico;

public class Empleado {
	//atributos
	private String nombre;
	private double salario;
	
	public String getNombre() {
		return nombre;
	}
	public double getSalario() {
		return salario;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getDetails() {
		return "Empleado [nombre=" + nombre + ", salario=" + salario + "]";
	}
}
