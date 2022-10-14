package oop;

public class PruebasCounter {
	public static void main(String[] args) {
		System.out.printf("counter vale %d %n ", Counter.getCounter());
		
		//crear 3 objetos Counter
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		
		//ver sus serial number
		System.out.printf("c1 %d %n c2 %d %n c2 %d %n",
				c1.getSerialNumber(),
				c2.getSerialNumber(),
				c3.getSerialNumber());
		
		//
	}
}
