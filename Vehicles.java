package proje3;

import java.util.ArrayList;
import java.util.Date;

public abstract class Vehicles {

    private String plateNumber;
    private int numberOfTires;
    protected double dailyFee;
    protected static ArrayList<Date> finalDate;
    protected static ArrayList<RegisteredUser> Owner;
    private static ArrayList<Integer> numOfDays;
    protected VehiclePark park;
    protected static ArrayList<Date> initialDate;
    private static int count;
    private int id;

    protected Vehicles(String plateNumber, int numberOfTires, double dailyFee) {
        this.plateNumber = plateNumber;
        this.numberOfTires = numberOfTires;
        this.dailyFee = dailyFee;

    }

    public int getId() {
        return id;
    }

    public Vehicles rentMe(Date endingDate, RegisteredUser rUser, Date initialDate) throws SorryWeDontHaveThatOneException {
        boolean b = true;
        long xi = initialDate.getTime();
        long xe = endingDate.getTime();
        for (int i = 0; i < finalDate.size(); i++) {
            if ((xi > Vehicles.initialDate.get(i).getTime() && xe < Vehicles.finalDate.get(i).getTime())
                    || (xi < Vehicles.initialDate.get(i).getTime() && xe > Vehicles.finalDate.get(i).getTime())
                    || (xi < Vehicles.finalDate.get(i).getTime() && xe > Vehicles.finalDate.get(i).getTime())) {
                b = false;
                break;
            }
        }

        if (b) {
            Vehicles.initialDate.add(initialDate);
            finalDate.add(endingDate);
            Owner.add(rUser);
            long hf = finalDate.get(count).getTime();
            long hi = Vehicles.initialDate.get(count).getTime();
            int nofd = (int) ((hf - hi) / (1000 * 60 * 60 * 24));
            numOfDays.add(nofd);
            ArrayList<Vehicles> c = Owner.get(count).getListOfMyVehicles();
            c.add(this);
            Owner.get(count).setListOfMyVehicles(c);
            count++;
            return this;
        } else {
            throw new SorryWeDontHaveThatOneException();

        }

    }

    public VehiclePark getPark() {
        return park;
    }

    public static ArrayList<Date> getFinalDate() {
        return finalDate;
    }

    public static ArrayList<Date> getInitialDate() {
        return initialDate;
    }

    public double getDailyFee(RegisteredUser rUser) {

        int ind = this.Owner.indexOf(rUser);
        return dailyFee * this.numOfDays.get(ind);

    }

    public void DropMe(RegisteredUser rUser) {

        System.out.println("you must pay the total price : " + getDailyFee(rUser));
        int ind = Vehicles.Owner.indexOf(rUser);
        Vehicles.Owner.remove(ind);
        Vehicles.numOfDays.remove(ind);
        finalDate.remove(ind);
        initialDate.remove(ind);

    }

}
