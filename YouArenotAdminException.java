package proje3;

public class YouArenotAdminException extends Exception {

    public YouArenotAdminException() {
        System.err.println("You are not admin");
    }

}
