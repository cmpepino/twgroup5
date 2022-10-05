package com.curso.varios;

public class Pila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2;
		meth1(a);
		System.out.println("Fin del Main");

	}
	
	public static void meth1(int numero) {
		int b = numero;
		meth2();
		System.out.println("fin meth1");
	}
	public static void meth2() {
		int c = 3;
		//if (c ==3) throw new RuntimeException("La has liado");
		String s = null;
		s.toUpperCase();//provoca un NullPointerException
		System.out.println("Fin meth2");
		//al salir destruye las variables(el espacio en memoria asignada para meth2)
	}

}
