package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;


import java.util.List;

/**
 * Dao interface for User domain bean
 * @author Hena Pamuk
 */
public interface UsersDao extends Dao<User>{

    /**
     * Search by name boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     * @throws MyException the my exception
     */
    boolean searchByName(String username, String password) throws MyException;

}