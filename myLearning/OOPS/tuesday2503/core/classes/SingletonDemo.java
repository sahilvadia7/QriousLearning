class Singleton {

    public static Singleton instance = null;
    public String s;

    private Singleton() {
        s = "This is a string part of Singleton class";
    }

    public static Singleton singleton() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("instance created");
    }
}

public class SingletonDemo {

    public static void main(String[] args) {
        Singleton.singleton().doSomething();
    }
}
