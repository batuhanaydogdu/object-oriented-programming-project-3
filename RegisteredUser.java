package proje3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RegisteredUser extends Person {

    private static int count;
    private int id;

    public RegisteredUser(String name, String contactinfo) {
        super(name, contactinfo);

        try {
            id = count;
            count++;
            File f = new File("RegisteredCustomers.file");
            PrintWriter prn = new PrintWriter(f);
            prn.println(this.toString());
            prn.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File does not exist!");
        }

    }

    public ArrayList<Vehicles> getListOfMyBookings() {
        return listOfMyBookings;
    }

    public ArrayList<Vehicles> getListOfMyVehicles() {
        return listOfMyVehicles;
    }

    public void setListOfMyBookings(ArrayList<Vehicles> listOfMyBookings) {
        this.listOfMyBookings = listOfMyBookings;
    }

    public void setListOfMyVehicles(ArrayList<Vehicles> listOfMyVehicles) {
        this.listOfMyVehicles = listOfMyVehicles;
    }

    public Vehicles rentVehicle() throws SorryWeDontHaveThatOneException {

        System.out.println("what is  your initial mount and day");
        Scanner x = new Scanner(System.in);
        Date inDate = new Date();
        int mounth = x.nextInt();
        inDate.setMonth(mounth);
        int dateday = x.nextInt();
        inDate.setDate(dateday);

        System.out.println("what is  your final mount and day");

        Date fDate = new Date();
        int mounthf = x.nextInt();
        fDate.setMonth(mounthf);
        int datedayf = x.nextInt();
        fDate.setDate(datedayf);

        displayAvailable(inDate, fDate);
        System.out.println("choose an id which you want to rent");
        int rid = x.nextInt();
        int innd = 0;
        for (int i = 0; i < park.getListOfVehicles().size(); i++) {
            if (park.getListOfVehicles().get(i).getId() == rid) {
                innd = i;
                break;

            }

        }

        try {
            return park.getListOfVehicles().get(innd).rentMe(fDate, this, inDate);
        } catch (SorryWeDontHaveThatOneException ex) {

            throw new SorryWeDontHaveThatOneException();

        }

    }

    public Vehicles bookVehicle() throws ItisnotBookableException {

        System.out.println("what is  your initial mount and day");
        Scanner x = new Scanner(System.in);
        Date inDate = new Date();
        int mounth = x.nextInt();
        inDate.setMonth(mounth);
        int dateday = x.nextInt();
        inDate.setDate(dateday);

        System.out.println("what is  your final mount and day");

        Date fDate = new Date();
        int mounthf = x.nextInt();
        fDate.setMonth(mounthf);
        int datedayf = x.nextInt();
        fDate.setDate(datedayf);

        displayAvailable(inDate, fDate);
        System.out.println("choose an id which you want to book");
        int rid = x.nextInt();
        int innd = 0;
        boolean bb = false;

        for (int i = 0; i < park.getListOfBookable().size(); i++) {
            if (park.getListOfBookable().get(i).getId() == rid) {
                innd = i;
                bb = true;
                break;

            }

        }

        if (park.getListOfBookable().get(innd) instanceof Bookable && bb) {
            try {
                Bookable b2 = (Bookable) park.getListOfBookable().get(innd);
                b2.bookMe(fDate, this, inDate);

            } catch (SorryWeDontHaveThatOneException ex) {
                System.err.println("Sorry we don't have that car! ");
            }

            return park.getListOfBookable().get(innd);
        } else {

            throw new ItisnotBookableException();

        }

    }

    public Vehicles cancelMyBooking() throws NoCancellationYouMustPayException {
        System.out.println("which one of your booking do you want to cancel?");
        for (int i = 0; i < this.listOfMyBookings.size(); i++) {

            System.out.println(this.listOfMyBookings.get(i).toString());

        }
        Scanner x = new Scanner(System.in);
        int ind = x.nextInt();
        if (this.listOfMyBookings.get(ind) instanceof Cancelable) {
            Cancelable c = (Cancelable) this.listOfMyBookings.get(ind);
            c.cancelMe(this);
            return this.listOfMyBookings.get(ind);
        } else {
            throw new NoCancellationYouMustPayException();
        }
    }

    public void loadMyVehicle() throws OverWeightException {
        int lcap;
        System.out.println("how much do you want to load?");
        Scanner x = new Scanner(System.in);
        lcap = x.nextInt();
        if (this instanceof Loadable) {

            Loadable l = (Loadable) this;
            l.loadMe(lcap);
        } else {
            System.out.println("your vehicle isnot loadable");
        }

    }

    public void searchTheVehiclesByType(Vehicles v) {

        if (v instanceof TransportTrucks) {
            System.out.println("TransportTrucks");
        } else if (v instanceof SmallTrucks) {
            System.out.println("SmallTrucks");
        } else if (v instanceof Sports) {
            System.out.println("Sports");
        } else if (v instanceof SW) {
            System.out.println("SW");
        } else if (v instanceof SUV) {
            System.out.println("SUV");
        } else {
            System.out.println("no appropriate type ");
        }

    }

    public Vehicles RemoteRentVehicles() throws SorryWeDontHaveThatOneException {
        System.out.println("what is  your initial month and day");
        Scanner x = new Scanner(System.in);
        Date inDate = new Date();
        int mounth = x.nextInt();
        inDate.setMonth(mounth);
        int dateday = x.nextInt();
        inDate.setDate(dateday);

        System.out.println("what is  your final month and day");

        Date fDate = new Date();
        int mounthf = x.nextInt();
        fDate.setMonth(mounthf);
        int datedayf = x.nextInt();
        fDate.setDate(datedayf);

        displayAvailable(inDate, fDate);
        System.out.println("choose an id which you want to rent");
        int rid = x.nextInt();
        int innd = 0;
        for (int i = 0; i < park.getListOfVehicles().size(); i++) {

            if (park.getListOfVehicles().get(i).getId() == rid) {
                innd = i;
                break;

            }

        }

        try {

            if (park.getListOfVehicles().get(innd) instanceof RemoteRentable) {
                System.out.println("what is your position");
                String pos = x.nextLine();
                RemoteRentable rr = (RemoteRentable) park.getListOfVehicles().get(innd);

                return rr.remoteRentMe(fDate, this, inDate, pos);
            } else {
                throw new SorryWeDontHaveThatOneException();
            }

        } catch (SorryWeDontHaveThatOneException ex) {

            throw new SorryWeDontHaveThatOneException();

        }
    }

}
