class StaticDemo {

    static int i = 0;
    int j = 0;

    public void counter() {
        i++;
        j++;
    }

    public void printStack() {
        System.out.println("Static var: " + i + " Non-Static :" + j);
    }
}

public class StaticWork {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            StaticDemo sd = new StaticDemo();
            sd.counter();
            sd.printStack();
        }
    }
}
