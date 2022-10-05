package com.mybank.test;

import com.mybank.domain.Customer;
import com.mybank.domain.Account;

public class TestCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cliente = new Customer("Sergio", "Ramos");
		//cliente.getFirstName();
		System.out.printf("%s, %s",cliente.getFirstName(),cliente.getLastName());
		System.out.println("");
		cliente.setAccount(500.00);
		Account r = cliente.getAccount();
		System.out.println(r.getBalance());

	}

}
