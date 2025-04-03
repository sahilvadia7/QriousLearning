import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student {

    private int number = 10;

    private void Info() {
        System.out.println("Hello form Student");
    }
}

public class PrivateClassOutSideTheMethod {

    public static void main(String[] args) {
        Student student = new Student();
        try {
            // access the private method outer class
            Method method = Student.class.getDeclaredMethod("Info");
            method.setAccessible(true);
            System.out.println(method.canAccess(student));
            System.out.println(method.getName());
            method.invoke(student);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

        //fetch the private varible forom student class
        Class<?> classinfo = student.getClass();
        System.out.println("Type :" + classinfo.getTypeName());
        try {
            Field field = classinfo.getDeclaredField("number");
            field.setAccessible(true);
            int number = (int) field.get(student);
            System.out.println(number);
            // field.set(number, field.get(number));
            // System.out.println(number);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
