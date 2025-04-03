class Student {

    private int rollno;
    private String name;
    private double marks;

    public Student() {}

    // Constructor
    public Student(int rollno, String name, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    // Getters and setters
    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "RollNO: " + rollno + " Name: " + name + " Marks: " + marks;
    }
}

public class Pojos {
    {}

    public static void main(String[] args) {
        Student jenil = new Student();
        jenil.setRollno(1);
        jenil.setName("jenil");
        jenil.setMarks(90);

        System.out.println(jenil);
    }
}
