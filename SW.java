package proje3;

import java.util.Date;

public class SW extends Car implements RemoteRentable, Loadable {

    private String Position;
    private final double loadingCap;
    private double amountofload;

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getPosition() {
        return Position;
    }

    public SW(double loadingCap, String color, String seatingCap, int numOfDoors, String plateNumber, int numberOfTires, double dailyFee) {
        super(color, seatingCap, numOfDoors, plateNumber, numberOfTires, dailyFee);
        this.loadingCap = loadingCap;
    }

    @Override
    public void loadMe(double loadingCap) throws OverWeightException {

        if (amountofload + loadingCap < this.loadingCap) {
            amountofload = amountofload + loadingCap;
        } else {
            throw new OverWeightException();

        }

    }

    @Override
    public Vehicles remoteRentMe(Date endingDate, RegisteredUser rUser, Date initialDate, String Position) throws SorryWeDontHaveThatOneException {

        if (this.Position.equals(Position)) {
            return this.rentMe(endingDate, rUser, initialDate);

        } else {
            throw new SorryWeDontHaveThatOneException();
        }

    }

    @Override
    public void RemoteDropMe(RegisteredUser rUser, String Position) {

        this.Position = Position;
        this.DropMe(rUser);

    }

}
