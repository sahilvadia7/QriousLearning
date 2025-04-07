package java8.streamapi.problemstatement;

public class Item {
	private String productName;
    private int quantity;
    private double pricePerUnit;
    
    public Item() {}
    
    
    
	public Item(String productName, int quantity, double pricePerUnit) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}



	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
    
    
}
