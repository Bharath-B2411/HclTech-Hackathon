import java.util.*;

class Vehicle {
    double ratePerDay;

    Vehicle(double rate) {
        ratePerDay = rate;
    }

    double calculateRentalCharge(int noOfDays) {
        return ratePerDay * noOfDays;
    }

    String getVehicleType() {
        return "Vehicle";
    }
}

class Car extends Vehicle {
    Car() {
        super(1500.0);
    }

    @Override
    String getVehicleType() {
        return "Car";
    }
}

class Bike extends Vehicle {
    Bike() {
        super(600.0);
    }

    @Override
    String getVehicleType() {
        return "Bike";
    }
}

class Truck extends Vehicle {
    Truck() {
        super(3000.0);
    }

    @Override
    String getVehicleType() {
        return "Truck";
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vehicleType = input.nextInt();
        int rentalDays = input.nextInt();
        Vehicle rentedVehicle;
        if (vehicleType == 1) {
            rentedVehicle = new Car();
        } else if (vehicleType == 2) {
            rentedVehicle = new Bike();
        } else {
            rentedVehicle = new Truck();
        }
        System.out.println("Vehicle Type: " + rentedVehicle.getVehicleType());
        System.out.printf("Rental Charge: %.2f%n",
                rentedVehicle.calculateRentalCharge(rentalDays));
        input.close();
    }
}
