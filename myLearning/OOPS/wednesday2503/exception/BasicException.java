import java.util.Scanner;

class SomethingWrong extends Exception {

    public SomethingWrong(String message) {
        super(message);
    }
}

public class BasicException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int statusCode = 0;

        try {
            System.out.print("Enter statusCode :");
            statusCode = sc.nextInt();
            System.out.println("Number :" + statusCode);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (statusCode == 404) throw new SomethingWrong(
                "Oops Something want wrong!!"
            );
        } catch (SomethingWrong sw) {
            System.out.println(sw.getMessage());
        } finally {
            try {
                sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.exit(0);
            }
        }
    }
}
