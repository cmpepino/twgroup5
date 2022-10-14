package oop_basico;

public class Granja {
	
	public void alimentarAnimales(Animal[] lista) {
		for(Animal a :lista) {
			a.comer;
		}
	}

	public static void main(String[] args) {
		Animal [] animales = {
				new Perro(),
				new Gato(),
				new PerroCaza(),
				new Vaca()
		};
		Granja granja = new Granja();
		granja.alimentarAnimales(animales);
		
	}
}
