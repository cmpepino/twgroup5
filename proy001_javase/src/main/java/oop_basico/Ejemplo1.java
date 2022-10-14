package oop_basico;

public class Ejemplo1 {
	public static void main(String[] args) {
		Empleado e = new Empleado();
		e.setNombre("Luis Ramos");
		e.setSalario(40000);
		
		Gerente g = new Gerente();
		g.setNombre("Begoña Olea");
		g.setDepartamento("Desarrollo");
		g.setSalario(70000);
		
		System.out.println("g es un gerente? "
						+(g instanceof Gerente));
		System.out.println("g es un empleado? "
				+(g instanceof Empleado));
		System.out.println("e es un gerente? "
				+(e instanceof Gerente));
		
		
		//una variable de referencia puede apuntar 
		//a objetos de su clase o clases hijas
		
		Empleado Carlos = new Gerente();
		Carlos.setNombre("Carlos Romero");
		Carlos.setSalario(45000);
		
		//Carlos tiene forma de empleado 
		//por lo tanto solo puede acceder a los metodos 
		//declarados en la clase empleado
	}
}
