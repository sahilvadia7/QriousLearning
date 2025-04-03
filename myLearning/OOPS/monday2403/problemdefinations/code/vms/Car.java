// package monday2403.problemdefinations.code.vms;

import java.time.Clock;
import java.time.LocalDateTime;

public class Car extends Vehicle {

    private int numberOfDoors;
    private int fixRate = 20;
    private Vehicle v = new Car();

    @Override
    public float calculateParkingFee(LocalDateTime exitTime) {
        // if (isElectric) {
        //     fixRate = 15;
        // } else {}
        return 0.0f;
    }

    @Override
    public void displayDetails(String registrationNumber) {}
}
