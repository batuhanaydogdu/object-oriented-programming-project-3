package proje3;

import java.util.Date;

public interface RemoteRentable extends RemoteDroppable {

    public abstract Vehicles remoteRentMe(Date endingDate, RegisteredUser rUser, Date initialDate, String Position) throws SorryWeDontHaveThatOneException;

}
