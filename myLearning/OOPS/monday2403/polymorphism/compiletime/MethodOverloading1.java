// compile time polymorphism also know as method overloading
// if return type or data type change still it called method overloading.
//
class calulation {

    public int add(int a, int b) {
        System.out.println("in the int add");

        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("in the int add 3");

        return a + b + c;
    }

    public double add(double a, double b) {
        System.out.println("in the double add");
        return a + b;
    }
    // not allowed
    // public double add(int a, int b) {
    //     System.out.println("in the double add");
    //     return a + b;
    // }
}

public class MethodOverloading1 {

    public static void main(String[] args) {
        calulation c = new calulation();
        System.out.println(c.add(1, 2.2));
    }
}
