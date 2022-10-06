package com.mybank.domain;

import java.util.Arrays;

public class Bank {
	
	//atributos
	
	private Customer[] customer;
	private int nCustomer;
	
	//constructores(duda)
	public Bank() {
		this.customer = new Customer[10];
		this.nCustomer = 0;
	}
	
	
	//metodos
	/**
	 * Metodo que añade un usuario al banco.
	 * para esto se crea un usuario y con su numero correspondiente se coloca en un array
	 * @param f string equivalente al nombre del usuario
	 * @param l string equivalente al apellido del usuario
	 */
	public void addCustomer(String f, String l) {
		Customer cliente = new Customer(f,l); //crea un usuario con nombre f y apellido l
		int indice = nCustomer++;	 	      //hace una copia del numero del cliente actual.
											  //incrementa el numero del cliente para el proximo espacio 
		customer[indice] = cliente;
		
		/*codigo mejorado by Begona  
 			VVVVVVVV
		 *customer[indice] = new Costumer (f,l); aqui llamas al constructor del cliente y despues lo guardas
		 */
	}
	
	public int getnumberCustomer() {
		return nCustomer;
	}
	
	public Customer getCustomer(int indice) {
		return customer[indice];
	}
	
	
}
