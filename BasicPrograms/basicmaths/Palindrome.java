import java.util.Scanner;

public class Palindrome {

    public static void main(String[] agrs) {
        Scanner se = new Scanner(System.in);
        System.out.print("Enter Number :");
        int no = se.nextInt();
        System.out.println("Number is Palindrome? : " + CheckPalindrome(no));
        se.close();
    }

    static boolean CheckPalindrome(int number) {
        int ld, reverse = 0, temp = number;

        while (temp > 0) {
            ld = temp % 10;
            reverse = reverse * 10 + ld;
            temp /= 10;
        }
        return number == reverse;
    }
}
