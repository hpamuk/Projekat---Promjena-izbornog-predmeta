package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;


import java.util.List;

public interface UsersDao extends Dao<User>{

    boolean searchByName(String username, String password) throws MyException;

}