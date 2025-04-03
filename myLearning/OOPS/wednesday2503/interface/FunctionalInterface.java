interface Human {
    void run();

    default void Greet() {
        System.out.println("Hello, there");
    }

    static void eat() {
        System.out.println("Eating...");
    }
}

interface Music {}

interface EarBuds extends Music {
    void playMusic(String name);
}

class Jenil implements Human, EarBuds {

    @Override
    public void run() {
        System.out.println("Jenil is Running.....");
    }

    @Override
    public void playMusic(String name) {
        System.out.println("Playing :" + name);
    }
}

public class FunctionalInterface {

    public static void main(String[] args) {
        Jenil jj = new Jenil();
        jj.Greet();
        jj.run();
        Human.eat();

        jj.playMusic("Kon talha");
        EarBuds eb = str -> System.out.println("Playing :" + str);
        eb.playMusic("Down At Dusk");

        //marker
        System.out.println(eb instanceof Music);
    }
}
