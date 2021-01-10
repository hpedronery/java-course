package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private Client client;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	public Double total() {
		double sum = 0;
		for (OrderItem c: items) {
			sum += c.subTotal();
		}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + getClient().getName() + "\n");
		sb.append("Order items:");
		for (OrderItem o : items) {
			sb.append(o.getProduct().getProductName() + ", ");
			sb.append("$" + String.format("%.2f", o.getProduct().getProductPrice()) + ", ");
			sb.append("Quantity: " + o.getQuantity() + ", ");
			sb.append("Subtotal: $" + String.format("%.2f", o.subTotal()) + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
}
