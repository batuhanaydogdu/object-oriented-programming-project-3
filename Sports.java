package proje3;

import java.util.ArrayList;
import java.util.Date;

public class Sports extends Car implements Bookable, RemoteRentable {

    private final int hp;
    protected String Position;

    public Sports(int hp, String color, String seatingCap, int numOfDoors, String plateNumber, int numberOfTires, double dailyFee) {
        super(color, seatingCap, numOfDoors, plateNumber, numberOfTires, dailyFee);
        this.hp = hp;

    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getPosition() {
        return Position;
    }

    @Override
    public Vehicles bookMe(Date initialDate, RegisteredUser rUser, Date finalDate) throws SorryWeDontHaveThatOneException {

        boolean b = true;
        long xi = initialDate.getTime();
        long xe = finalDate.getTime();
        for (int i = 0; i < Sports.finalDate.size(); i++) {
            if ((xi > Sports.initialDate.get(i).getTime() && xe < Sports.finalDate.get(i).getTime())
                    || (xi < Sports.initialDate.get(i).getTime() && xe > Sports.finalDate.get(i).getTime())
                    || (xi < Sports.finalDate.get(i).getTime() && xe > Sports.finalDate.get(i).getTime())) {
                b = false;
                break;
            }
        }

        if (b) {
            ArrayList<Vehicles> c = rUser.getListOfMyBookings();
            c.add(this);
            rUser.setListOfMyBookings(c);
            return this;

        } else {
            throw new SorryWeDontHaveThatOneException();
        }
    }

    @Override
    public Vehicles cancelMe(RegisteredUser rUser) throws NoCancellationYouMustPayException {

        int ind = Vehicles.Owner.indexOf(rUser);
        long bas = new Date().getTime();
        long bas2 = Vehicles.initialDate.get(ind).getTime();
        if (bas2 > bas) {

            ArrayList<Vehicles> c = rUser.getListOfMyBookings();
            c.remove(this);
            rUser.setListOfMyBookings(c);
            DropMe(rUser);
            return this;
        } else {
            throw new NoCancellationYouMustPayException();
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
