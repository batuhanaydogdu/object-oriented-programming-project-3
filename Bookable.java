package proje3;

import java.util.Date;

public interface Bookable extends Cancelable {

    public abstract Vehicles bookMe(Date initialDate, RegisteredUser rUser, Date finalDate) throws SorryWeDontHaveThatOneException;

}
