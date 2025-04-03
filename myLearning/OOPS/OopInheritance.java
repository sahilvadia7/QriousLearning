class Vehicle {

    private int year;
    private String name;
    private String type;
    private int speed;

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSpeed(int speed) {
        if (speed > 60) {
            System.out.println("overspeed");
        } else {
            this.speed = speed;
        }
    }

    public int getSpeed() {
        return speed;
    }

    void Info() {
        System.out.println("Vehicle Info");
        System.out.println("Year :" + year);
        System.out.println("Name :" + name);
        System.out.println("Speed :" + speed);
        System.out.println("Type :" + type);
    }
}

class Bike extends VehicleDemo {

    public static void bikeColor(String color) {
        System.out.println("color :" + color);
    }
}

public class OopInheritance {

    public static void main(String[] args) {
        VehicleDemo bike = new Bike();
        bike.setName("TVS Victor");
        bike.setType("2  W");
        bike.setYear(2018);
        bike.setSpeed(80);
        bike.Info();
        Bike.bikeColor("black");
    }
}
