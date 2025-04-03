class Greet {

    private static String greet = "Hello World";

    static class innerClass {

        void printMessage() {
            System.out.println("Message :" + greet);
        }
    }
}

public class StaticClass {

    public static void main(String[] agrs) {
        Greet.innerClass gi = new Greet.innerClass();
        gi.printMessage();
    }
}
