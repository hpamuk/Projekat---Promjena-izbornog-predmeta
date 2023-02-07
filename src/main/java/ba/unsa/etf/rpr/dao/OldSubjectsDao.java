package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public interface OldSubjectsDao extends Dao<OldSubject> {

    public OldSubject addOldSubject(OldSubject oldSubject);
    public List<OldSubject> getOdgovarajuce(String username) throws MyException;

}

