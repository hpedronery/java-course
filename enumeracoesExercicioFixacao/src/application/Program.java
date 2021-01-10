package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date moment = new Date();
		
		System.out.println("Enter client data:");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY)");
		Date birthDate = sdf.parse(sc.nextLine());
		
		System.out.println("Enter order data:");
		System.out.println("Status: ");
		String status = sc.nextLine();
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		Order order = new Order(moment, OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		for (int i=0; i<n; i++) {
			System.out.println("Product name: ");
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			sc.nextLine();
			System.out.println("Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			OrderItem orderItem = new OrderItem(productQuantity, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);		
		sc.close();
	}

}
