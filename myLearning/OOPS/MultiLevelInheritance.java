class ClassRoom {

    public String cName;

    public ClassRoom() {}

    public ClassRoom(ClassRoom cr) {
        this.cName = cr.cName;
    }
}

class Division extends ClassRoom {

    public String div;

    public Division() {}

    public Division(Division d) {
        super(d);
        this.div = d.div;
    }
}

class Student extends Division {

    public String sName;

    public Student() {}

    public Student(Division division, String sName) {
        super(division);
        this.sName = sName;
    }
}

public class MultiLevelInheritance {

    public static void main(String[] agrs) {
        Division d = new Division();
        d.cName = "IMCA";
        d.div = "A";

        Student s = new Student(d, "jenil");
        System.out.println(s.cName);
        System.out.println(s.div);
        System.out.println(s.sName);
    }
}
