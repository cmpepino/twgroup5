package com.mybank.domain;

public class Customer {
	// atributos
	
	private String firstName, lastName;
	
	// private Account account = new Account(0);// duda
	private Account account;

	// constructor
	
	public Customer(String f, String l) {
		// validar los string
		if (f == null && l == null) {
			throw new RuntimeException("Error!! No ha ingresado correctamente el nombre");
		}
		firstName = f;
		lastName = l;
		// this.account = new Account(0);//puedo inicializar atributos sin pasarle el
		// mismo por argumento
	}

	// metodos
	
	/**
	 * Obtener el nombre del cliente
	 * @return String que contiene el nombre del cliente
	 */
	public String getFirstName() {
		return firstName;

	}
	/**
	 * Obtener el apellido del cliente
	 * @return String que contiene el apellido del cliente
	 */
	public String getLastName() {
		return lastName;

	}
	/**
	 * para pedir la cuenta de un cliente 
	 * @return la direccion de la instancia tipo Cuenta que tiene la variable de referencia Account
	 */
	// duda
	public Account getAccount() {
		return account;
	}

	/**
	 * Creación de una cuenta depósito para el cliente
	 * 
	 * @param acc dato tipo double que es el dinero que va a tener el deposito
	 */

	public void setAccount(double acc) {
		// validar valor de la account
		if (acc < 0) {
			throw new RuntimeException("Su cuenta no puede inicializarse con numeros negativos");
		}
		// valor de la cuenta inicial = acc
		account = new Account(acc);
		// account.deposit(acc);
	}

//	@Override
//	public String toString() {
//		return "Cliente es " + lastName +"," + firstName ;
//	}
	

}
