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

	// cosntructores
	public Account(double initBalance) {
		if (initBalance < 0)
			throw new RuntimeException("Error!! Su cuenta no puede iniciarse en numeros negativos");
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
	 * @param money dinero a depositar
	 * @return verdadero si se completo satisfactoriamente
	 */
	public boolean deposit(double money) {
		if (money < 0)
			throw new RuntimeException("Error!! No se puede depositar valores negativo a tu cuenta");
		balance += money;
		System.out.println("El deposito se ha completado saisfactoriamente. Su Balance actual es: " + balance);
		return true;
	}

	/**
	 * 
	 * @param money
	 * @return
	 */
	public boolean withdraw(double money) {
		if (money > balance){
			throw new RuntimeException("Dinero insuficiente");}else {
				
			}
		balance -= money;
		System.out.println("El retiro se ha completado saisfactoriamente. Su Balance actual es: " + balance);
		return true;
	}
}
