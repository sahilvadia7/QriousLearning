import java.util.Scanner;

public class Swithcase {

    public static void main(String[] args) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        double b = 1.99;
        System.out.println(b);

        while (i != 10) {
            System.out.println();
            System.out.println("Welcome to Menu Card");
            System.out.println("1. File");
            System.out.println("2. New File");
            System.out.println("3. Open");

            System.out.println("10. exit");
            System.out.print("Select option :");
            i = input.nextInt();
            Menu(i);
        }
        input.close();
    }

    public static void Menu(int i) {
        switch (i) {
            case 1:
                System.out.println("In The File");
                break;
            case 2:
                System.out.println("creating new file");
                break;
            case 3:
                System.out.println("opening file");
                break;
            default:
                System.out.println("select proper option");
                break;
        }
    }
}
