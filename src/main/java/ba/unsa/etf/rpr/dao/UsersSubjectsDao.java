package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public interface UsersSubjectsDao extends Dao<UserSubject>{

    public List<UserSubject> getByUsername(String username) throws MyException;
    public void deleteByName(String username, String subject);
    public void addNewUserSubject(String username, String subject);
    public boolean searchByUsernameAndSubject(String username, String subject) throws MyException;
}
