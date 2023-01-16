package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class OldSubjectManager {

    public List<OldSubject> getAll() throws MyException {
        return DaoFactory.oldSubjectsDao().getAll();
    }

    public OldSubject getById(int oldSubjectId) throws MyException{
        return DaoFactory.oldSubjectsDao().getById(oldSubjectId);
    }

    public void update(OldSubject q) throws MyException{
        DaoFactory.oldSubjectsDao().update(q);
    }

}
