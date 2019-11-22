package proje3;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Date;
import java.util.Scanner;

public class TestClass {

    private static Scanner scn;
    private static Person currentPerson;
    private static VehiclePark myPark;

    public static void main(String[] args) {
        scn = new Scanner(System.in);

        loadFiles();
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("(Press 1) Display all vehicles");
            System.out.println("(Press 2) Display available vehicles");
            System.out.println("(Press 3) Register me");
            System.out.println("(Press 4) Continue as registered user:");
            System.out.println("(Press 5) Continue as admin");
            System.out.println("(Press 6) Quit ");
            System.out.print(">>: ");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    displayAllVehicles();
                    break;
                case 2:
                    displayAvailableVehicles();
                    break;
                case 3:
                    registerMe();
                    break;
                case 4:

                    userMenu();
                    break;
                case 5:

                    adminMenu();
                    break;
                case 6:
                    saveAll();
                    System.out.println("byeee");
                    return;
            }
        }

    }

    private static void userMenu() {
        currentPerson = findTheUserWithId();
        while (true) {
            System.out.println("(Press 1) Display all vehicles");
            System.out.println("(Press 2) Display available vehicles");
            System.out.println("(Press 3) Display available vehicles by type");
            System.out.println("(Press 4) Book Vehicle");
            System.out.println("(Press 5) Cancel my booking");
            System.out.println("(Press 6) Rent vehicle");
            System.out.println("(Press 7) Remote Rent vehicle");
            System.out.println("(Press 8) Remote Drop vehicle");
            System.out.println("(Press 9) Drop vehicle");
            System.out.println("(Press 10) Quit");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    displayAllVehicles();
                    break;
                case 2:
                    displayAvailableVehicles();
                    break;
                case 3:
                    displayAvailableVehiclesbyType();
                    break;
                case 4:
                    bookVehicle();
                    break;
                case 5:
                    cancelMyBooking();
                    break;
                case 6:
                    rentVehicle();
                    break;
                case 7:
                    remoteRentVehicle();
                    break;
                case 8:
                    remoteDropVehicle();
                    break;
                case 9:
                    dropVehicle();
                    break;
                case 10:
                    saveAll();
                    currentPerson = null;
                    return;
            }
        }

    }

    private static void adminMenu() {
        currentPerson = findTheAdminWithId();
        while (true) {
            System.out.println("(Press 1) Display all vehicles");
            System.out.println("(Press 2) Display available vehicles");
            System.out.println("(Press 3) Add new Vehicle");
            System.out.println("(Press 4) Remove Vehicle");
            System.out.println("(Press 5) Create Reports");
            System.out.println("(Press 6) Quit");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    displayAllVehicles();
                    break;
                case 2:
                    displayAvailableVehicles();
                    break;
                case 3:
                    addNewVehicle();
                    break;
                case 4:
                    removeVehicle();
                    break;
                case 5:
                    saveAll();
                    break;
                case 6:
                    saveAll();
                    currentPerson = null;
                    return;
            }
        }
    }

    private static Person findTheAdminWithId() {
        System.out.println("chose admin id");

        for (int i = 0; i < myPark.getListOfRegisteredCustomers().size(); i++) {
            if (myPark.getListOfRegisteredCustomers().get(i) instanceof Admin) {
                System.out.println(myPark.getListOfRegisteredCustomers().get(i).toString());
            }

        }
        int id = scn.nextInt();
        return myPark.getListOfRegisteredCustomers().get(id);
    }

    private static Person findTheUserWithId() {

        System.out.println("chose user id");

        for (int i = 0; i < myPark.getListOfRegisteredCustomers().size(); i++) {
            if (myPark.getListOfRegisteredCustomers().get(i) instanceof RegisteredUser);
            System.out.println(myPark.getListOfRegisteredCustomers().get(i).toString());

        }
        int id = scn.nextInt();
        return myPark.getListOfRegisteredCustomers().get(id);

    }

    private static void displayAvailableVehiclesbyType() {

        System.out.println("What is your starting month and day ");
        Scanner x = new Scanner(System.in);
        Date startingDate = new Date();
        int mounth = x.nextInt();
        startingDate.setMonth(mounth);
        int dateday = x.nextInt();
        startingDate.setDate(dateday);

        System.out.println("What is your ending month and day ");

        Date endingDate = new Date();
        int mounthf = x.nextInt();
        endingDate.setMonth(mounthf);
        int datedayf = x.nextInt();
        endingDate.setDate(datedayf);

        myPark.displayAvailableVehicles(startingDate, endingDate);
    }

    private static void bookVehicle() {
        myPark.bookVehicle();
    }

    private static void cancelMyBooking() {

        myPark.cancelBooking();
    }

    private static void rentVehicle() {

        myPark.cancelBooking();
    }

    private static void remoteRentVehicle() {
        myPark.remoteRentVehicle();
    }

    private static void dropVehicle() {

        myPark.dropVehicle();
    }

    private static void remoteDropVehicle() {
        myPark.remoteDropVehicle();
    }

    private static void addNewVehicle() {

        try {
            myPark.addVehicle();
        } catch (YouArenotAdminException ex) {
            System.out.println("You are not an admin so you cannot do that!");
        }
    }

    private static void removeVehicle() {

        myPark.removeVehicle();
    }

    private static void loadFiles() {

        File f = new File("RegisteredCustomers.file");
        try {
            Scanner scn = new Scanner(f);
            while (scn.hasNext()) {
                int x = scn.nextInt();
                System.out.println(x);
            }
            scn.close();

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        }
    }

    private static void displayAllVehicles() {
        myPark.displayVehicles();
    }

    private static void displayAvailableVehicles() {
        System.out.println("What is your starting month and day ");
        Scanner x = new Scanner(System.in);
        Date startingDate = new Date();
        int mounth = x.nextInt();
        startingDate.setMonth(mounth);
        int dateday = x.nextInt();
        startingDate.setDate(dateday);

        System.out.println("What is your ending month and day ");

        Date endingDate = new Date();
        int mounthf = x.nextInt();
        endingDate.setMonth(mounthf);
        int datedayf = x.nextInt();
        endingDate.setDate(datedayf);
        myPark.displayAvailableVehicles(startingDate, endingDate);

    }

    private static void registerMe() {

        if (currentPerson instanceof Person) {
            Person p = (Person) currentPerson;
            p.register();

        }
    }

    private static void saveAll() {

        myPark.dailyReport();
    }
}
