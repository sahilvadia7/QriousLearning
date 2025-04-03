abstract class Vehicle {

    private String name;
    private String type;
    private boolean dos;
    private boolean engine;
    private boolean light;
    private int speed;
    private String fule_type;
    private int fuel_cap;
    private int curr_fuel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDos() {
        return dos;
    }

    public void setDos(boolean dos) {
        if (dos != true) {
            this.engine = false;
            this.light = false;
            this.speed = 0;
        } else {
            this.dos = dos;
        }
    }

    public boolean isEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        if (dos == false) {
            this.engine = engine;
        }
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        if (this.engine == true) this.light = light;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (this.engine == true) this.speed = speed;
    }

    public void setFule_type(String fule_type) {
        this.fule_type = fule_type;
    }

    public String getFule_type() {
        return fule_type;
    }

    public int getFuel_cap() {
        return fuel_cap;
    }

    public void setFuel_cap(int fuel_cap) {
        this.fuel_cap = fuel_cap;
    }

    public int getCurr_fuel() {
        return curr_fuel;
    }

    public void setCurr_fuel(int curr_fuel) {
        if (this.fuel_cap >= curr_fuel) {
            this.curr_fuel = curr_fuel;
        } else {
            this.curr_fuel = this.fuel_cap - 1;
        }
    }

    public void Info() {
        System.out.println("Name : " + getName());
        System.out.println("Type : " + getType());
        System.out.println("Door :" + isDos());
        System.out.println("Engine : " + isEngine());
        System.out.println("Light : " + isLight());
        System.out.println("Speed : " + getSpeed());
        System.out.println("Fule Type : " + getFule_type());
        System.out.println("Fuel CAP : " + getFuel_cap());
        System.out.println("Current Fuel: " + getCurr_fuel());
    }
}

class Car extends Vehicle {}

public class VehicleDemo {

    public static void main(String[] args) {
        Vehicle Bmw = new Car();
        Bmw.setName("Bmw M2");
        Bmw.setType("4 W");
        Bmw.setDos(false);
        Bmw.setEngine(true);
        Bmw.setLight(true);
        Bmw.setSpeed(100);
        Bmw.setFule_type("Petrol");
        Bmw.setFuel_cap(50);
        Bmw.setCurr_fuel(50);
        Bmw.Info();
    }
}
