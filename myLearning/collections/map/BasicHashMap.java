import java.util.HashMap;
import java.util.Map;

public class BasicHashMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);

        System.out.println(map);
    }
}
