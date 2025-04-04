import java.util.HashSet;
import java.util.Set;

public class HashsetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("date");
        set.add("date"); // no duplicate allowed in set
        set.add("cherry");
        set.add(null);
        set.add(null);
        set.add(null);

        System.out.println(set.isEmpty());
        System.out.println(set.size());

        System.out.println(set);
    }
}
