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
        flowers.add("Jasmine");
        flowers.add("Daisy");

        flowers.forEach(System.out.println);
    }
}
