// Find the sum of digits of a number.
public class SumOfDigit {

    public static void main(String[] args) {
        System.out.println(SumOfDigitM(555));
    }

    public static int SumOfDigitM(int digit) {
        int sum = 0, ld;

        while (digit > 0) {
            ld = digit % 10;
            sum += ld;
            digit /= 10;
        }

        return sum;
    }
}
