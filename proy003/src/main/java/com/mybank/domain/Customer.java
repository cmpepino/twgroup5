package com.mybank.domain;

public class Customer {
	// atributos
	private String firstName, lastName;
	// private Account account = new Account(0);// duda
	private Account account;

	// constructor
	public Customer(String f, String l) {
		firstName = f;
		lastName = l;
	}

	// metodos
	public String getFirstName() {
		return firstName;

	}

	public String getLastName() {
		return lastName;

	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(double acc) {
		// validar valor de la account
		if (acc < 0)
			throw new RuntimeException("Su cuenta no puede inicializarse con numeros negativos");
		// valor de la cuenta inicial = acc
		account = new Account(acc);
	}

}
