abstract class Cake {

    abstract void build();
}

public class Anonymous extends Cake {
    static {
        int i = 10;
        i = 20;
        System.out.println(i);
    }

    @Override
    public void build() {
        System.out.println("Cake Building");
    }

    public static void main(String[] agrs) {
        Cake chocoLava = new Cake() {
            @Override
            public void build() {
                System.out.println("ChocoLava");
            }
        };
        chocoLava.build();
    }
}
