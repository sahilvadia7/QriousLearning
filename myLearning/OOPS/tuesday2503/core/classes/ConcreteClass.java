class concrete {

    public void greet() {
        System.out.println("concrete class");
    }
}

public class ConcreteClass {

    public static void main(String[] args) {
        concrete con = new concrete();
        con.greet();
    }
}
