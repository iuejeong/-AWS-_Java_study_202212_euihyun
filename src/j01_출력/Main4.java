package j01_출력;


class Order {
	
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;
	
	public void showOrderInfo() {
		
		Order order = new OrderBuilder()
					.orderId(100)
					.productName("Samsung GalaxyBook2 Pro")
					.consumerName("홍길동")
					.price(1450000)
					.stock(2)
					.build();
	}
}

class OrderBuilder {
	
	public static OrderBuilder builder() {
		return new OrderBuilder();
	}
	
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;
	
	public OrderBuilder orderId(int orderId) {
		this.orderId = orderId;
		return this;
	}
	
	public OrderBuilder productName(String productName) {
		this.productName = productName;
		return this;
	}
	
	public OrderBuilder consumerName(String consumerName) {
		this.consumerName = consumerName;
		return this;
	}
	public OrderBuilder price(int price) {
		this.price = price;
		return this;
	}
	
	public OrderBuilder stock(int stock) {
		this.stock = stock;
		return this;
	}
	
	public Order build() {
		return new Order();
	}
	

}

public class Main4 {
	
	public static void main(String[] args) {
		
		Order order = null;
		order.showOrderInfo();
	}
}
