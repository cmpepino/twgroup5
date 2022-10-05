package com.curso.varios;

public class ReferenciaHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno a = new Alumno(1);
		meth1(a);
		System.out.println("id del alumno es "+a.getId());
		System.out.println("Fin del Main");

	}
	
	public static void meth1(Alumno a) {
		Alumno b = a;
		meth2();
		System.out.println("fin meth1");
	}
	public static void meth2() {
		Alumno c = new Alumno(3);
		//if (c ==3) throw new RuntimeException("La has liado");
		/*String s = null;
		s.toUpperCase();//provoca un NullPointerException*/
		System.out.println("Fin meth2");
		//al salir destruye las variables(el espacio en memoria asignada para meth2)
	}

}
