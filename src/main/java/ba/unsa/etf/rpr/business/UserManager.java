package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

/**
 *  Business Logic Layer for management of Users
 *  @author Hena Pamuk
 */
public class UserManager {

    /**
     * Gets all.
     *
     * @return the all
     * @throws MyException the my exception
     */
    public List<User> getAll() throws MyException {
        return DaoFactory.usersDao().getAll();
    }

    /**
     * Gets by id.
     *
     * @param userId the user id
     * @return the by id
     * @throws MyException the my exception
     */
    public User getById(int userId) throws MyException{
        return DaoFactory.usersDao().getById(userId);
    }

    /**
     * Update.
     *
     * @param q the q
     * @throws MyException the my exception
     */
    public void update(User q) throws MyException{
        DaoFactory.usersDao().update(q);
    }

    /**
     * Search by name boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     * @throws MyException the my exception
     */
    public boolean searchByName(String username, String password) throws MyException {
        return DaoFactory.usersDao().searchByName(username,password);
    }

}
