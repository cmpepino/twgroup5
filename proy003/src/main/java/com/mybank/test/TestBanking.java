package com.mybank.test;
import com.mybank.domain.*;


public class TestBanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Creando el cliente Sergio Ramos");
//		Customer cliente = new Customer("Sergio", "Ramos");
//		System.out.println("Creando su cuenta bancaria con saldo con 500.00");
//		cliente.setAccount(500.00);
//		Account acc = cliente.getAccount();//duda hay otra forma de acceder a los metodos de la clase account 
//		System.out.println("Sacar 150: "+ cliente.getAccount().withdraw(150));
//		System.out.println("Ingresar 22.5: " + acc.deposit(22.5));
//		System.out.println("Sacar 47.62: "+ acc.withdraw(47.62));
//		System.out.println("Sacar 400: "+ acc.withdraw(400));
//		System.out.printf("El usuario/cliente [%s, %s] tiene un saldo de %f", cliente.getLastName(), cliente.getFirstName(), acc.getBalance());
//		
		Bank ing = new Bank();
		ing.addCustomer("Carlos", "Perez");
		ing.addCustomer("Jane", "Simmons");
		ing.addCustomer("Owen", "Bryant");
		ing.addCustomer("Maria", "Soley");
		
			
		System.out.println(ing.getnumberCustomer());
		for(int i = 0; i < ing.getnumberCustomer();i++) {	
		System.out.println("Cliente [" + (i+1) + "] es: " + ing.getCustomer(i).getLastName() + "," + ing.getCustomer(i).getFirstName());
		}

	}

}
