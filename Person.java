package proje3;

import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;

public class Person {

    private String name;
    private String contactInfo;
    protected VehiclePark park;
    protected ArrayList<Vehicles> listOfMyBookings;
    protected ArrayList<Vehicles> listOfMyVehicles;

    public void display() {
        ArrayList c = park.getListOfVehicles();

        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i).toString());

        }

    }

    public void myVehicleDisplay() {

        for (int i = 0; i < listOfMyBookings.size(); i++) {
            System.out.println(listOfMyBookings.get(i).toString());

        }

    }

    public void displayAvailable(Date initialDate, Date finalDate) {

        Scanner scn = new Scanner(System.in);

        ArrayList c = park.getListOfVehicles();

        System.out.println("which type you want to chose");

        int a = scn.nextInt();

        System.out.println("Press 1 for TransportTruck");
        System.out.println("Press 2 for SmallTruck");
        System.out.println("Press 3 for Sport Car");
        System.out.println("Press 4 for SW");
        System.out.println("Press 5 for SUV");

        switch (a) {
            case 1:
                for (int i = 0; i < c.size(); i++) {

                    if (c.get(i) instanceof TransportTrucks) {
                        System.out.println(c.get(i).toString());
                    }

                }
                break;
            case 2:
                for (int i = 0; i < c.size(); i++) {

                    if (c.get(i) instanceof SmallTrucks) {
                        System.out.println(c.get(i).toString());
                    }

                }
                break;
            case 3:
                for (int i = 0; i < c.size(); i++) {

                    if (c.get(i) instanceof Sports) {
                        System.out.println(c.get(i).toString());
                    }

                }
                break;
            case 4:
                for (int i = 0; i < c.size(); i++) {

                    if (c.get(i) instanceof SW) {
                        System.out.println(c.get(i).toString());
                    }

                }
                break;
            case 5:
                for (int i = 0; i < c.size(); i++) {

                    if (c.get(i) instanceof SUV) {
                        System.out.println(c.get(i).toString());
                    }

                }
                break;
            default:
                System.out.println("Not appropriate type ");
                break;
        }

        boolean b = true;
        long xi = initialDate.getTime();
        long xe = finalDate.getTime();

        for (int j = 0; j < c.size(); j++) {
            for (int i = 0; i < Vehicles.finalDate.size(); i++) {
                b = true;
                if ((xi > Vehicles.initialDate.get(i).getTime() && xe < Vehicles.finalDate.get(i).getTime())
                        || (xi < Vehicles.finalDate.get(i).getTime() && xe > Vehicles.finalDate.get(i).getTime())
                        || (xi < Vehicles.finalDate.get(i).getTime() && xe > Vehicles.finalDate.get(i).getTime())) {
                    b = false;
                    break;
                }

            }

            if (b) {
                System.out.println(c.get(j).toString());
            }

        }

    }

    public Person(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public RegisteredUser register() {
        Scanner x = new Scanner(System.in);
        System.out.println("enter your name");
        name = x.nextLine();
        System.out.println("enter contact info");
        contactInfo = x.nextLine();

        System.out.println("now, you are a registered user.");
        return new RegisteredUser(name, contactInfo);

    }

    public void displayAllAvailableVehicles(Date startingDate, Date endingDate) {

        ArrayList c = park.getListOfVehicles();
        for (int i = 0; i < c.size(); i++) {

            System.out.println(c.get(i).toString());

        }
    }

}
