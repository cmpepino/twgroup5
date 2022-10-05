package com.mybank.test;
import com.mybank.domain.Account;
import com.mybank.domain.Customer;

public class TestBanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creando el cliente Sergio Ramos");
		Customer cliente = new Customer("Sergio", "Ramos");
		System.out.println("Creando su cuenta bancaria con saldo con 500.00");
		cliente.setAccount(500.00);
		Account acc = cliente.getAccount();//duda hay otra forma de acceder a los metodos de la clase account 
		System.out.println("Sacar 150: "+ acc.withdraw(150));
		System.out.println("Ingresar 22.5: " + acc.deposit(22.5));
		System.out.println("Sacar 47.62: "+ acc.withdraw(47.62));
		System.out.println("Sacar 400: "+ acc.withdraw(400));
		System.out.printf("El usuario/cliente [%s, %s] tiene un saldo de %f", cliente.getLastName(), cliente.getFirstName(), acc.getBalance());
		
		

	}

}
