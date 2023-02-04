package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;

import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class UserSubjectManager {
    public List<UserSubject> getAll() throws MyException {
        return DaoFactory.usersSubjectsDao().getAll();
    }
}
