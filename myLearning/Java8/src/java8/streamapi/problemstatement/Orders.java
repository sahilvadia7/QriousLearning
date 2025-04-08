package java8.streamapi.problemstatement;

import java.time.LocalDate;
import java.util.List;

public class Orders {
	
	private int id;
	private String customerName;
	private List<Item> item;
	private boolean isDelivered;
	private LocalDate orderDate;
	
	public Orders() {}
	
	public Orders(int id, String customerName, List<Item> item, boolean isDelivered, LocalDate orderDate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.item = item;
		this.isDelivered = isDelivered;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public boolean isDelivered() {
		return isDelivered;
	}
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	

}
