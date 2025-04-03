abstract class Employee {

    //abstact method
    abstract void salaryCalculation();

    //not allowed, only public or protected allowed
    // abstract final void testing();
    static void test() {
        System.out.println("in static testing {Root}");
    }

    abstract int testing(int i);

    //non-abstract method
    void info(String str) {
        System.out.println("Root Calc");
        System.out.println("Employee: " + str);
    }
}

class Developer extends Employee {

    private int salary = 6000;

    public void salaryCalculation() {
        salary -= 100;
        System.out.println("salary :" + salary);
    }

    @Override
    public int testing(int id) {
        Employee.test();
        return 0;
    }
    // @Override
    // public void info(String str) {
    //     System.out.println("Employee Calc");
    //     System.out.println("Employee: " + str);
    // }
}

public class AbstractClass {

    public static void main(String[] agrs) {
        Developer jenil = new Developer();
        jenil.info("jenil");
        jenil.salaryCalculation();

        Employee.test();

        Employee e = new Employee() {
            @Override
            public void salaryCalculation() {
                System.out.println("in Anonymous");
            }

            @Override
            public void info(String str) {
                System.out.println("Anonymous Employee Calc");
                System.out.println("Employee: " + str);
            }

            @Override
            public int testing(int i) {
                return 0;
            }
        };
        e.salaryCalculation();
        e.info("sahil");
    }
}
