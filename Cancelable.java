package proje3;

public interface Cancelable {

    public abstract Vehicles cancelMe(RegisteredUser rUser) throws NoCancellationYouMustPayException;
}
