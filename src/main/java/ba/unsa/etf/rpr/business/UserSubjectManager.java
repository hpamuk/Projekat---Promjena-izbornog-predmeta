package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;

import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class UserSubjectManager {
    public List<UserSubject> getAll() throws MyException {
        return DaoFactory.usersSubjectsDao().getAll();
    }
    public List<UserSubject> getByUsername(String username) throws MyException {
        return DaoFactory.usersSubjectsDao().getByUsername(username);
    }
    public void deleteByName(String username, String naziv) {
        DaoFactory.usersSubjectsDao().deleteByName(username, naziv);
    }
    public void addNewUserSubject(String username, String naziv) {
        DaoFactory.usersSubjectsDao().addNewUserSubject(username, naziv);
    }

}
