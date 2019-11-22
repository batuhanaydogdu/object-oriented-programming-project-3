package proje3;

public class SUV extends Car {

    private final String wheelDrive;

    public SUV(String wheelDrive, String color, String seatingCap, int numOfDoors, String plateNumber, int numberOfTires, double dailyFee) {
        super(color, seatingCap, numOfDoors, plateNumber, numberOfTires, dailyFee);
        this.wheelDrive = wheelDrive;
    }

}
