interface Calculator {
    int add(int x);
}

interface Greet {
    String greeting(String str);
}

public class FunctionalInter {

    public static void main(String[] args) {
        Calculator calc = x -> (x + 2) * 2;
        int ans = calc.add(10);
        System.out.println(ans);
    }
}
