package oop_enumeraciones;

public class Carta {
	//atributos
	private Palos palos;
	private int valor;
	
	//constructor
	public Carta(Palos palo, int valor) {
		super();
		this.palos = palo;
		this.valor = valor;
		
	}
	
	//metodos
	
	public Palos getPalos() {
		return palos;
	}
	public int getValor() {
		return valor;
	}
	
}
