class Calculator {

    public int add(int i, int j) {
        return i + j;
    }

    public int add(int i, int j, int k) {
        return i + j + k;
    }
}

class ScincetificCal extends Calculator {

    @Override
    public int add(int i, int j) {
        return i + j + 2;
    }
}

public class OopPolymorphism {

    public static void main(String[] args) {
        ScincetificCal sci = new ScincetificCal();
        System.out.println(sci.add(1, 1));
    }
}
