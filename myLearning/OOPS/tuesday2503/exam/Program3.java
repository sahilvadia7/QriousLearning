// 3. You are given a list of employees, where each employee has the following attributes:

// ID (Unique identifier)
// Name (Employee's name)
// Department (Department where the employee works)
// Salary (Employee's salary)

// Your task is to find the employee with the 3rd highest salary from the given list.
//

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Employee {

    private int id;
    private String name;
    private String department;
    private float salary;

    public Employee() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }
}

public class Program3 {

    // static Employee e = new Employee();
    static Employee[] emp = new Employee[3];

    public static void main(String[] args) {
        AddEmployee();
        printData();
        MaxSalary();
    }

    public static void AddEmployee() {
        int i = 0;
        Scanner se = new Scanner(System.in);

        while (i < emp.length) {
            Employee e = new Employee();
            System.out.println("Enter ID, Name, Salary, Department:");
            e.setId(se.nextInt());
            e.setName(se.next());
            e.setSalary(se.nextFloat());
            e.setDepartment(se.next());

            emp[i] = e;
            i++;
        }
        se.close();
    }

    public static void printData() {
        int count = 0;
        for (Employee e : emp) {
            System.out.println("\nEmployee :" + count + " Detail");
            System.out.println("ID: " + e.getId());
            System.out.println("Name: " + e.getName());
            System.out.println("Salary: " + e.getSalary());
            System.out.println("Department: " + e.getDepartment());
            count++;
        }
    }

    public static void MaxSalary() {
        if (emp.length < 3) {
            System.out.println(
                "Not enough employees to determine the 3rd highest salary."
            );
            return;
        }

        Arrays.sort(emp, Comparator.comparing(Employee::getSalary).reversed());

        Employee thirdHighest = emp[2];

        System.out.println("\n3rd Highest Salary: " + thirdHighest.getSalary());
        System.out.println("Employee Name: " + thirdHighest.getName());
        System.out.println("Employee ID: " + thirdHighest.getId());
        System.out.println("Department: " + thirdHighest.getDepartment());
    }
}
