package proje3;

public class TransportTrucks extends Truck {

    private boolean goesAbroad;

    public TransportTrucks(boolean goesAbroad, double loadingCap, String plateNumber, int numberOfTires, double dailyFee) {
        super(loadingCap, plateNumber, numberOfTires, dailyFee);
        this.goesAbroad = goesAbroad;
    }

}
