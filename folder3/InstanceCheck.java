interface Animal {}

class Dog implements Animal {}

public class InstanceCheck {

    public static void main(String[] args) {
        Dog dog = new Dog();
        boolean check = dog instanceof Animal;
        System.out.println(check);
    }
}
