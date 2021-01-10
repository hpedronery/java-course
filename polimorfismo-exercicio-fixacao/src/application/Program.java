package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.println("Common, used or imported (c/u/i)? ");
			char condition = sc.nextLine().charAt(0);
			System.out.println("Name: ");
			String name = sc.nextLine();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			sc.nextLine();
			if(condition == 'i') {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				sc.nextLine();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			if(condition == 'u') {
				System.out.println("Manufacture date (DD/MM/YYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				sc.nextLine();
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			if(condition == 'c') {
				list.add(new Product(name, price));
			}
		}
		System.out.println("\nPRICE TAGS:");
		for(Product prod: list) {
			System.out.println(prod);
		}
		sc.close();
	}
}
