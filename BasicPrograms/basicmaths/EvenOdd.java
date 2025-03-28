// Check if a number is even or odd.
public class EvenOdd {

    public static void main(String[] args) {
        System.out.println(checkEO(10));
        System.out.println(checkEO(11));
    }

    public static boolean checkEO(int i) {
        return i % 2 == 0;
    }
}
