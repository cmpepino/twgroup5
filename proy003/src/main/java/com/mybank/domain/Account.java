package com.mybank.domain;

/**
 * Clase que permite realizar operaciones basicas (obtener, depositar, retirar)
 * con cuentas bancarias.
 * 
 * @author Carlos
 * @version 1.0
 *
 */
public class Account {
	
	// atributos
	private double balance;

	// constructores
	public Account(double initBalance) {
		if (initBalance < 0) {
			throw new RuntimeException("Error!! Su cuenta no puede iniciarse en numeros negativos");
	}
		balance = initBalance;
	}

	// metodos
	/**
	 * Metodo para obtener el balance de la cuenta en cuestion
	 * 
	 * @return una variable tipo double que representa el dinero de la cuenta
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Metodo que permite depositar dinero en la cuenta. No se puede depositar
	 * valores negativos pues significaria un retiro y no un deposito
	 * 
	 * @param money dato tipo double que representa el dinero a depositar
	 * @return verdadero si se completó satisfactoriamente la operacion
	 */
	public boolean deposit(double money) {
		if (money < 0) {
			//throw new RuntimeException("Error!! No se puede depositar valores negativo a tu cuenta");
			return false;
		}
		balance += money;
		System.out.println("El deposito se ha completado satisfactoriamente. Su Balance actual es: " + balance);
		return true;
	}

	/**
	 * Metodo que permite retirar dinero en la cuenta.
	 * no se puede retirar valores mayores que lo que esta depositado en la cuenta.
	 * si se retira 0, se da una alarma.
	 * @param money dato tipo double que representa el dinero a retirar
	 * @return true si se ha realizado correctamente la operacion
	 */
	public boolean withdraw(double money) {
		if (money > balance ) {
			// throw new RuntimeException("Dinero insuficiente");
			return false;
		} else if (money <= 0) {
			System.out.println("Cancelada la operacion. No ha sacado dinero. Su Balance actual es: " + balance);
			return false;
		}
		balance -= money;
		System.out.println("El retiro se ha completado saisfactoriamente. Su Balance actual es: " + balance);
		return true;
	}
}
