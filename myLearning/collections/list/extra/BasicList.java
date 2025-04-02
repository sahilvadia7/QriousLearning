import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

public class BasicList {

    public static void main(String[] args) {
        List<String> carNames = new ArrayList<>();
        List<String> car1 = new ArrayList<>();
        List<String> car2 = new ArrayList<>();

        car1.add("Audi A8");
        car1.add("Audi R8");
        car1.add("Audi R1");
        car1.add("Audi R2");
        car1.add("Audi R7");

        car2.add("Audi A8");
        car2.add("Audi R8");
        car2.add("Audi R1");
        carNames.clear();
        carNames.add("Bmw X1");
        carNames.add("Bmw X6");
        carNames.add("Bmw M2");
        carNames.add("Bmw M2");
        carNames.add("Bmw M3");
        carNames.add("Bmw M1");
        carNames.add("Bmw M2 Competition");
        carNames.add("Bmw M7 Competition");
        carNames.add("Bmw M3 Competition");
        carNames.add(2, "Audi Q8");

        carNames.stream().forEach(System.out::println);
        System.out.println("Contains :" + carNames.contains("Audi Q8"));
        System.out.println(
            "car 1 containsAll car 2: " + car1.containsAll(car2)
        );

        carNames.set(2, "BMW M8");
        Collections.sort(carNames);

        Object[] carsArray = carNames.toArray();

        for (Object item : carsArray) {
            System.out.println(item);
        }

        System.out.println(carsArray instanceof Object);

        car1.retainAll(car2);
        car1.forEach(System.out::println);
        carNames.stream().forEach(n -> System.out.print(n + ", "));

        Spliterator<String> c1 = carNames.spliterator();
        Spliterator<String> c2 = c1.trySplit();

        System.out.println("Spliterator");
        while (c1.tryAdvance(n -> System.out.print(n + ", ")));
        System.out.println();
        while (c2.tryAdvance(n -> System.out.print(n + ", ")));

        carNames.trimToSize();
    }
}
