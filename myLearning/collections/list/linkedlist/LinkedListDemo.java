import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> flowers = new LinkedList<>();
        flowers.add("Rose");
        flowers.add("Lily");
        flowers.add("Lotus");
        flowers.add("Marigold");
        flowers.add("Sunflower");
        flowers.add("Hibiscus");
        flowers.add("Hibiscus");
        flowers.add("Lotus");

        flowers.add("Jasmine");
        flowers.add("Jasmine");
        flowers.add("Lotus");

        flowers.add("Daisy");

        flowers.offer("Tulip");
        flowers.offerFirst("Marigold");
        flowers.offerLast("Gardenia");
        flowers.removeFirstOccurrence("Hibiscus");

        flowers.forEach(System.out::println);

        System.out.println("----- Peek -----");
        System.out.println(flowers.peek());
        System.out.println(flowers.peekFirst());
        System.out.println(flowers.peekLast());

        System.out.println("----- Poll -----");
        System.out.println(flowers.poll());
        System.out.println(flowers.pollFirst());
        System.out.println(flowers.pollLast());
    }
}
