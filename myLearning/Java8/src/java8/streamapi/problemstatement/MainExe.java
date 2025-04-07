package java8.streamapi.problemstatement;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MainExe {

	public static void main(String[] args) {


		List<Orders> orders = List.of(
		    new Orders(1, "Alice", List.of(
		        new Item("Phone", 1, 20000),
		        new Item("Cover", 2, 500)
		    ), true, LocalDate.of(2024, 12, 20)),

		    new Orders(2, "Bob", List.of(
		        new Item("Tablet", 1, 25000)
		    ), false, LocalDate.of(2025, 1, 5)),

		    new Orders(3, "Charlie", List.of(
		        new Item("Laptop", 1, 50000),
		        new Item("Mouse", 2, 1000)
		    ), true, LocalDate.of(2025, 1, 15)),

		    new Orders(4, "David", List.of(
		        new Item("Phone", 2, 18000)
		    ), true, LocalDate.of(2025, 2, 2)),

		    new Orders(5, "Eva", List.of(
		        new Item("Charger", 3, 800),
		        new Item("Headphones", 1, 2500)
		    ), true, LocalDate.of(2025, 2, 20)),

		    new Orders(6, "Fiona", List.of(
		        new Item("Smartwatch", 1, 7000)
		    ), false, LocalDate.of(2025, 3, 5)),

		    new Orders(7, "George", List.of(
		        new Item("Tablet", 1, 22000),
		        new Item("Keyboard", 1, 1500)
		    ), true, LocalDate.of(2025, 3, 10)),

		    new Orders(8, "Hannah", List.of(
		        new Item("Monitor", 1, 12000),
		        new Item("Mouse", 1, 900)
		    ), true, LocalDate.of(2025, 4, 1)),

		    new Orders(9, "Ian", List.of(
		        new Item("Phone", 1, 19000)
		    ), false, LocalDate.of(2025, 4, 3)),

		    new Orders(10, "Jane", List.of(
		        new Item("Phone", 3, 18000),
		        new Item("Cover", 3, 500)
		    ), true, LocalDate.of(2025, 4, 6))
		);

		double totalRevenue = orders.stream()
								.filter(Orders::isDelivered)
								.flatMap(order -> order.getItem().stream())
								.mapToDouble(item -> item.getQuantity()*item.getPricePerUnit())
								.sum();
		
		System.out.println("Total Revenue: "+totalRevenue);
		
		orders.stream()
			.filter(Orders::isDelivered)
			.flatMap(order -> order.getItem().stream())
			
			.forEach(System.out::println);
	}
}

