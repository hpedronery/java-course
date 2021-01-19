package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyPayer;
import entities.IndividualPayer;
import entities.Payer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Payer> list = new ArrayList<>();
		System.out.println("Quantity of contribuitions");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.println("Individual or company (i/c)? ");
			char ch = sc.nextLine().charAt(0);
			System.out.println("Name: ");
			String name = sc.nextLine();
			System.out.println("Anual income: ");
			double anualIncome = sc.nextDouble();
			sc.nextLine();

			if (ch == 'i') {
				System.out.println("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				sc.nextLine();
				list.add(new IndividualPayer(name, anualIncome, healthExpenditures));
			}
			if (ch == 'c') {
				System.out.println("Number of Employees");
				int numberEmployees = sc.nextInt();
				sc.nextLine();
				list.add(new CompanyPayer(name, anualIncome, numberEmployees));
			}
		}
		System.out.println();
		System.out.println("TAXES PAID");
		double sum = 0.0;
		for (Payer p : list) {
			System.out.println(p.getName() + ": $ " + String.format("%.2f", p.totalTax()));
			sum += p.totalTax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		sc.close();
	}

}
