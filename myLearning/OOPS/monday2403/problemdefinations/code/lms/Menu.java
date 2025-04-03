// package monday2403.problemdefinations.code.lms;

import java.util.Scanner;

public class Menu {

    public static void getMainMenu() {
        System.out.println("welcome to library");
        System.out.println("1. admin");
        System.out.println("2. user");
    }

    public static void getAdminPanel() {
        System.out.println();
        System.out.println("Admin panel");
        System.out.println("1. AddBooks");
        System.out.println("2. RemoveBook");
    }

    public static void getUserPanel() {
        System.out.println();
        System.out.println("User panel");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opt = -1;
        while (opt != 0) {
            getMainMenu();
        }
    }
}
