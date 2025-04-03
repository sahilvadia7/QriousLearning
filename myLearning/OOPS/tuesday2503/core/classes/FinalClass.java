interface testable {
    void test();
}

final class Greet implements testable {

    @Override
    public void test() {
        System.out.println("Testing....");
    }

    void greeting() {
        System.out.println("Greeting fromo Greet{Root}");
    }
}

// not allowed to extends final class
// class Hello extends Greet {
class Hello {

    public void greeting() {
        System.out.println("Greeting fromo Hello");
    }
}

public class FinalClass {

    public static void main(String[] args) {
        Hello h1 = new Hello();
        h1.greeting();

        Greet gg = new Greet();
        gg.test();
    }
}
