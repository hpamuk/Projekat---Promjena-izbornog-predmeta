package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class NewSubjectManager {

    public List<NewSubject> getAll() throws MyException {
        return DaoFactory.newSubjectsDao().getAll();
    }

    public NewSubject getById(int userId) throws MyException{
        return DaoFactory.newSubjectsDao().getById(userId);
    }

    public void update(NewSubject q) throws MyException{
        DaoFactory.newSubjectsDao().update(q);
    }

}
