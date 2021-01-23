package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		try {
			System.out.println("Enter account data");
			System.out.println("Number: ");
			int number = sc.nextInt();
			sc.nextLine();	
			System.out.println("Holder: ");
			String holder = sc.nextLine();
			System.out.println("Initial balance: ");
			Double balance = sc.nextDouble();
			sc.nextLine();
			System.out.println("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			sc.nextLine();
			System.out.println();
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println(account);
			
		}
		
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
