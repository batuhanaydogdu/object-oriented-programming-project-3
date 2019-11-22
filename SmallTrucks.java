package proje3;

import java.util.Date;

public class SmallTrucks extends Truck implements RemoteRentable {

    private String Position;

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getPosition() {
        return Position;
    }

    public SmallTrucks(double loadingCap, String plateNumber, int numberOfTires, double dailyFee) {
        super(loadingCap, plateNumber, numberOfTires, dailyFee);
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
