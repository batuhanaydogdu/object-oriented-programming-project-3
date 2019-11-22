package proje3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends Person {

    private static int count;
    private int id;
    private String userName;

    public Admin(int id, String userName, String name, String contactInfo) {
        super(name, contactInfo);
        id = count;
        count++;
        this.userName = userName;
    }

    public Vehicles addNewVehicle() {
        Scanner x = new Scanner(System.in);
        System.out.println("which type do you want to add");
        System.out.println("1 TransportTrucks  - 2 SmallTrucks   -  3 Sports  - 4 SW   -  5  SUV");
        int c = x.nextInt();
        Vehicles v = null;
        if (c == 1) {
            try {
                System.out.println("can it go abroad");
                boolean ab = x.nextBoolean();
                System.out.println("what is its loadingcap");
                double locap = x.nextDouble();
                System.out.println("what is plate number");
                String platnum = x.nextLine();
                System.out.println("what is numberOfTires");
                int numoft = x.nextInt();
                System.out.println("what is dailyFee");
                double dailyf = x.nextDouble();
                v = new TransportTrucks(ab, locap, platnum, numoft, dailyf);
            } catch (InputMismatchException ex) {
                System.err.println("you wrote wrong");
                x.nextLine();
            }

        } else if (c == 2) {
            try {
                System.out.println("what is its loadingcap");
                double locap = x.nextDouble();
                System.out.println("what is plate number");
                String platnum = x.nextLine();
                System.out.println("what is numberOfTires");
                int numoft = x.nextInt();
                System.out.println("what is dailyFee");
                double dailyf = x.nextDouble();
                v = new SmallTrucks(locap, platnum, numoft, dailyf);
            } catch (InputMismatchException ex) {
                System.err.println("you wrote wrong");
                x.nextLine();
            }

        } else if (c == 3) {
            try {

                System.out.println("what is hp");
                int hp = x.nextInt();
                System.out.println("what is color");
                String color = x.nextLine();
                System.out.println("what is seatingcap");
                String seatcap = x.nextLine();
                System.out.println("what is numOfDoors");
                int nofd = x.nextInt();
                System.out.println("what is plate number");
                String platnum = x.nextLine();
                System.out.println("what is numberOfTires");
                int numoft = x.nextInt();
                System.out.println("what is dailyFee");
                double dailyf = x.nextDouble();
                v = new Sports(hp, color, seatcap, nofd, platnum, numoft, dailyf);

            } catch (InputMismatchException ex) {
                System.err.println("you wrote wrong");
                x.nextLine();
            }

        } else if (c == 4) {
            try {
                System.out.println("what is its loadingcap");
                double locap = x.nextDouble();
                System.out.println("what is color");
                String color = x.nextLine();
                System.out.println("what is seatingcap");
                String seatcap = x.nextLine();
                System.out.println("what is numOfDoors");
                int nofd = x.nextInt();
                System.out.println("what is plate number");
                String platnum = x.nextLine();
                System.out.println("what is numberOfTires");
                int numoft = x.nextInt();
                System.out.println("what is dailyFee");
                double dailyf = x.nextDouble();

                v = new SW(locap, color, seatcap, nofd, platnum, numoft, dailyf);

            } catch (InputMismatchException ex) {
                System.err.println("you wrote wrong");
                x.nextLine();
            }
        } else if (c == 5) {
            try {

                System.out.println("what is wheelDrive");
                String whd = x.nextLine();
                System.out.println("what is color");
                String color = x.nextLine();
                System.out.println("what is seatingcap");
                String seatcap = x.nextLine();
                System.out.println("what is numOfDoors");
                int nofd = x.nextInt();
                System.out.println("what is plate number");
                String platnum = x.nextLine();
                System.out.println("what is numberOfTires");
                int numoft = x.nextInt();
                System.out.println("what is dailyFee");
                double dailyf = x.nextDouble();

                v = new SUV(whd, color, seatcap, nofd, platnum, numoft, dailyf);

            } catch (InputMismatchException ex) {
                System.err.println("you wrote wrong");
                x.nextLine();
            }
        } else {
            System.out.println("no appropriate type ");
        }
        return v;

    }

    public Vehicles removeVehicle() throws YouChoseWrongVehicle {
        display();
        boolean b = false;
        Scanner x = new Scanner(System.in);
        System.out.println("which vehicle do you want to remove enter id");
        int rid = x.nextInt();
        int ind = 0;
        for (int i = 0; i < park.getListOfVehicles().size(); i++) {

            if (park.getListOfVehicles().get(i).getId() == rid) {
                ind = i;
                b = true;
            }
        }
        if (b) {
            return park.getListOfVehicles().get(ind);

        } else {
            throw new YouChoseWrongVehicle();
        }

    }

}
