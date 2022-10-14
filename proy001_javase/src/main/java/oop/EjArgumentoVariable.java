package oop;

public class EjArgumentoVariable {
	private static int suma(int n, int nn, int nnn) {
		return n + nn + nnn;
	}
	private static int suma(int n, int nn) {
		return  n + nn;
	}
	private static int suma(int... numeros) {
		int r = 0;
		for(int i : numeros) {
			r += i;
		}
		return r;
	}
	
	
}
