import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<>();

        cars.add("Audi A8");
        cars.addFirst("Audi R8");
        cars.add("Audi R1");
        cars.addLast("Audi R2");
        cars.add("Audi R7");
        cars.add("Bmw X1");
        cars.add("Bmw X6");
        cars.add("Bmw M2");
        cars.add("Bmw M2");
        cars.add("Bmw M3");
        cars.add("Bmw M1");
        cars.add("Bmw M2 Competition");
        cars.add("Bmw M7 Competition");
        cars.add("Bmw M3 Competition");

        List<String> mycar = (LinkedList) cars.clone();
        System.out.println(mycar);

        // mycar.forEach(System.out.println);

        cars.forEach(n -> System.out.print(n + ", "));
        System.out.println();
        System.out.println("getFirst() :" + cars.getFirst());
        // System.out.println("peek() :" + ((LinkedList<String>) cars).peek());
        System.out.println("peek() :" + cars.peek());
        // System.out.println("pop() :" + cars.pop());
        // System.out.println("push() :" + cars.push("Audi A8R"));
    }
}
