// public class Stack<E> extends Vector<E>

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<String> animal = new Stack<>();
        animal.add("Goat");
        animal.add("Dog");
        animal.add("Lion");
        animal.add("Tiger");
        animal.add("Cat");

        animal.forEach(n -> System.out.println(n));
        System.out.println(animal.search("Dog"));

        System.out.println("----Reverse Stack----");
        while (!animal.empty()) {
            System.out.println(animal.pop());
        }
    }
}
