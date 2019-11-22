package proje3;

public abstract class Car extends Vehicles {

    protected String color;
    protected String seatingCap;
    protected int numOfDoors;

    public Car(String color, String seatingCap, int numOfDoors, String plateNumber, int numberOfTires, double dailyFee) {
        super(plateNumber, numberOfTires, dailyFee);
        this.color = color;
        this.seatingCap = seatingCap;
        this.numOfDoors = numOfDoors;
    }

}
