package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public interface UsersSubjectsDao extends Dao<UserSubject>{
    List<UserSubject> getByUsername(String username) throws MyException;
}
