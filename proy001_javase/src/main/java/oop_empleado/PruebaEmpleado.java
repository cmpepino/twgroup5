package oop_empleado;

public class PruebaEmpleado {
	public static void main(String[] args) {
//		Empleado e = new Empleado();
//		e.setNombre("Luis");
//		e.setSalario(2000.0);
////		
////		
//		Gerente g = new Gerente();
//		g.setNombre("Carlos");
//		g.setSalario(3000.0);
//		g.setDepartamento("Ingenieria");
//		
//		System.out.println(e.getDetails());
//		System.out.println(g.getDetails());
//		
//		Ingeniero i = new Ingeniero();
//		i.setNombre("Pepe");
//		i.setSalario(2500.0);
//		i.setProyecto("IoT");
//		
//		System.out.println(i.getDetails());
		
		
		Empleado e22 = new Gerente();
		e22.setNombre("Rosa");
		e22.setSalario(15000);
		System.out.println(e22.getDetails());
		e22.saluda();//No estamos sobrecargando. Ejecuta metodo estatico de
						// Empleado, es decir, mirar el tipo de la variable de referencia
		
//		Empleado.saluda();
//		Gerente.saluda();
		
		
//		Empleado e01 = new Empleado("mario", 1000.0);
//		Gerente g01 = new Gerente("Dona",1500.0, "Ventas"); 
//		
//		System.out.println(e01.getDetails());
//		System.out.println(g01.getDetails());
	}
}
