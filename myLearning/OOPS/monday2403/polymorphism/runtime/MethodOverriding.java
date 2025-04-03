package monday2403.polymorphism.runtime;

//runtime polymorphism also know as Method overrinding (Dynamic method dispatch)

class Employee {

    public void Greet() {
        System.out.println("Employer Greet");
    }
}

class Developer extends Employee {

    @Override
    public void Greet() {
        System.out.println("Greet form Dev");
    }
}

class Manager extends Employee {}

public class MethodOverriding {

    public static void main(String[] args) {
        Developer dev1 = new Developer();
        dev1.Greet();

        Manager m1 = new Manager();
        m1.Greet();
    }
}
// virtual function's
// in java every method is virtual function
// private, final and static it is not virtual function
