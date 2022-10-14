package oop_basico;

public class Animal {
	//atributos
	private String sonido;
	//constructor
	
	//metodos
	public void comer() {
		System.out.println("Estoy comiendo...");
	}
}

class Gato extends Animal{
	
	@Override
	public void comer() {
		System.out.println("Como ratones...");
	}
	
}

class Perro extends Animal{
	private String raza;

	@Override
	public void comer() {
		System.out.println("Estoy comiendo huesos y pienso");
	}
}

class PerroCaza extends Perro{
	private String altura;

	public void olfatear() {
		System.out.println("estoy olfateando  ");
	}
	@Override
	public void comer() {
		System.out.println("Estoy comiendo huesos, carne y pienso");
	}
}


