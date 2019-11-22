package proje3;

import java.util.ArrayList;
import java.util.Date;

public abstract class Truck extends Vehicles implements Bookable, Loadable {

    private final double loadingCap;
    private double amountofload;

    public Truck(double loadingCap, String plateNumber, int numberOfTires, double dailyFee) {
        super(plateNumber, numberOfTires, dailyFee);
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
    public Vehicles bookMe(Date initialDate, RegisteredUser rUser, Date finalDate) throws SorryWeDontHaveThatOneException {

        long nowt = new Date().getTime();
        long initialt = initialDate.getTime();

        if ((initialt - nowt) > 1000 * 60 * 60 * 24 * 7) {
            ArrayList<Vehicles> c = rUser.getListOfMyBookings();
            c.add(this);
            rUser.setListOfMyBookings(c);
            return this.rentMe(finalDate, rUser, initialDate);

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

}
