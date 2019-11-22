package proje3;

public class NoCancellationYouMustPayException extends Exception {

    public NoCancellationYouMustPayException() {
    }

    public NoCancellationYouMustPayException(String msg) {
        super(msg);
    }
}
