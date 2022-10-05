package com.mybank.test;
import com.mybank.domain.Account;

public class PruebaAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account a = new Account(50);
		System.out.println("Su cuenta bancaria es: " + a.getBalance());
		
		a.deposit(50);
		
		a.withdraw(0);
		

	}

}
