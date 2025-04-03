class ParentA {

    int getNumber() {
        return 10;
    }
}

class ParentB {

    String getMessage() {
        return "Hello from ParentB";
    }
}

// class Child extends ParentA, ParentB { }

public class MultipleExtends {

    public static void main(String[] args) {
        // Child obj = new Child();
        // System.out.println(obj.getNumber()); // From ParentA
        // System.out.println(obj.getMessage()); // From ParentB
    }
}
