import java.lang.reflect.Constructor;

abstract class Car {

    private Car() {
        System.out.println("Car Constructor Called");
    }

    public void Info() {
        System.out.println("Car Info");
    }
}

public class ObjOfAbstract {

    public static void main(String[] args) {
        try {
            Constructor<Car> constructor = Car.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Car audi = constructor.newInstance();
            audi.Info();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
