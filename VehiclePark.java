package proje3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class VehiclePark {

    private ArrayList<Vehicles> listOfVehicles;
    private ArrayList<Vehicles> listOfBookable;
    private ArrayList<Vehicles> listOfRentedVehicles;
    private ArrayList<Person> listOfRegisteredCustomers;
    private Person currentUser;

    public VehiclePark() {
    }

    public ArrayList<Person> getListOfRegisteredCustomers() {
        return listOfRegisteredCustomers;
    }

    public ArrayList<Vehicles> getListOfBookable() {
        return listOfBookable;
    }

    public void setListOfBookable(ArrayList<Vehicles> listOfBookable) {
        this.listOfBookable = listOfBookable;
    }

    public void setListOfVehicles(ArrayList<Vehicles> listOfVehicles) {
        this.listOfVehicles = listOfVehicles;
    }

    public void displayVehicles() {

        currentUser.display();

    }

    public ArrayList<Vehicles> getListOfVehicles() {
        return listOfVehicles;
    }

    public void displayAvailableVehicles(Date startingDate, Date endingDate) {

        currentUser.displayAvailable(startingDate, endingDate);

    }

    public void displayAllAvailableVehicles(Date startingDate, Date endingDate) {
        currentUser.displayAllAvailableVehicles(startingDate, endingDate);
    }

    public void displayRemotelyAvailableVehicles(Date startingDate, Date endingDate) {
        for (int i = 0; i < listOfVehicles.size(); i++) {

            if (listOfVehicles.get(i) instanceof RemoteRentable) {
                RemoteRentable rr = (RemoteRentable) listOfVehicles.get(i);

                System.out.println(listOfVehicles.get(i).toString());

            }
        }

    }

    public void addVehicle() throws YouArenotAdminException {

        if (currentUser instanceof Admin) {
            Admin a = (Admin) currentUser;
            Vehicles v = a.addNewVehicle();
            listOfVehicles.add(v);
            if (v instanceof Bookable) {
                listOfBookable.add(v);

            }
        } else {
            throw new YouArenotAdminException();
        }

    }

    public void removeVehicle() {

        if (currentUser instanceof Admin) {
            try {

                Admin a = (Admin) currentUser;
                if (a.removeVehicle() instanceof Bookable) {
                    listOfBookable.remove(a.removeVehicle());
                }
                listOfVehicles.remove(a.removeVehicle());

            } catch (YouChoseWrongVehicle ex) {

                System.err.println("you chose wrong vehicle");

            }

        }
    }

    public void bookVehicle() {

        if (currentUser instanceof RegisteredUser) {

            try {
                RegisteredUser ru = (RegisteredUser) currentUser;
                listOfBookable.add(ru.bookVehicle());
                listOfRentedVehicles.add(ru.bookVehicle());
            } catch (ItisnotBookableException ex) {
                System.err.println("It is not bookable vehicle!");
            }

        }

    }

    public void cancelBooking() {
        if (currentUser instanceof RegisteredUser) {

            try {
                RegisteredUser ru = (RegisteredUser) currentUser;
                listOfBookable.add(ru.cancelMyBooking());
                listOfRentedVehicles.add(ru.cancelMyBooking());
            } catch (NoCancellationYouMustPayException ex) {
                System.err.println("No cancelation You must pay!");
            }

        }
    }

    public void rentVehicle() {
        if (currentUser instanceof RegisteredUser) {

            try {
                RegisteredUser ru = (RegisteredUser) currentUser;

                listOfRentedVehicles.add(ru.rentVehicle());
            } catch (SorryWeDontHaveThatOneException ex) {
                System.err.println("Sorry we don't have that car");
            }

        }
    }

    public void remoteRentVehicle() {

        if (currentUser instanceof RegisteredUser) {

            try {
                RegisteredUser ru = (RegisteredUser) currentUser;

                listOfRentedVehicles.add(ru.RemoteRentVehicles());
            } catch (SorryWeDontHaveThatOneException ex) {
                System.err.println("Sorry we don't have that car");
            }

        }

    }

    public void dropVehicle() {

        currentUser.display();
        boolean b = false;
        Scanner x = new Scanner(System.in);
        System.out.println("which vehicle do you want to drop enter id");
        int rid = x.nextInt();
        int ind = 0;
        for (int i = 0; i < listOfVehicles.size(); i++) {

            if (listOfVehicles.get(i).getId() == rid) {
                ind = i;
                b = true;
            }
        }
        if (b) {
            if (currentUser instanceof RegisteredUser) {
                RegisteredUser ru = (RegisteredUser) currentUser;

                listOfVehicles.get(ind).DropMe(ru);
                listOfVehicles.remove(ind);
            }
        } else {
            try {
                throw new YouChoseWrongVehicle();
            } catch (YouChoseWrongVehicle ex) {
                System.err.println("You chose wrong vehicle to drop!");
            }
        }
    }

    public void remoteDropVehicle() {

        currentUser.myVehicleDisplay();
        boolean b = false;
        Scanner x = new Scanner(System.in);
        System.out.println("which vehicle do you want to remote drop enter id");
        int rid = x.nextInt();
        int ind = 0;
        for (int i = 0; i < listOfVehicles.size(); i++) {

            if (listOfVehicles.get(i).getId() == rid) {
                ind = i;
                b = true;
            }
        }
        if (b) {
            if (currentUser instanceof RegisteredUser) {
                RegisteredUser ru = (RegisteredUser) currentUser;

                listOfVehicles.get(ind).DropMe(ru);
                listOfVehicles.remove(ind);

            }
        } else {
            try {
                throw new YouChoseWrongVehicle();
            } catch (YouChoseWrongVehicle ex) {
                System.err.println("You chose wrong vehicle to drop!");
            }
        }

    }

    public void loadVehicle() throws OverWeightException {
        if (currentUser instanceof RegisteredUser) {

            try {
                RegisteredUser ru = (RegisteredUser) currentUser;
                ru.loadMyVehicle();

            } catch (OverWeightException ex) {
                System.err.println("over weight");
            }

        }

    }

    public void dailyReport() {
        if (currentUser instanceof Admin) {
            File f = new File("daily.report");
            try {
                PrintWriter prn = new PrintWriter(f);
                prn.println(" List of Vehicles ");
                for (int i = 0; i <= listOfVehicles.size(); i++) {
                    prn.println(listOfVehicles.toString());
                }
                prn.println(" List of Customers ");
                for (int i = 0; i <= listOfRegisteredCustomers.size(); i++) {
                    prn.println(listOfRegisteredCustomers.toString());
                }

                prn.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            }
        }
    }

}
