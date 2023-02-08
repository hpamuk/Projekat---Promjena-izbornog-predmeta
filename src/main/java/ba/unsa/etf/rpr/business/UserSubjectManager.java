package ba.unsa.etf.rpr.business;


import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

/**
 *  Business Logic Layer for management of UsersSubjects
 *  @author Hena Pamuk
 */
public class UserSubjectManager {

    /**
     * Gets all.
     *
     * @return the all
     * @throws MyException the my exception
     */
    public List<UserSubject> getAll() throws MyException {
        return DaoFactory.usersSubjectsDao().getAll();
    }

    /**
     * Gets by username.
     *
     * @param username the username
     * @return the by username
     * @throws MyException the my exception
     */
    public List<UserSubject> getByUsername(String username) throws MyException {
        return DaoFactory.usersSubjectsDao().getByUsername(username);
    }

    /**
     * Delete by name.
     *
     * @param username the username
     * @param naziv    the naziv
     */
    public void deleteByName(String username, String naziv) {
        DaoFactory.usersSubjectsDao().deleteByName(username, naziv);
    }

    /**
     * Add new user subject.
     *
     * @param username the username
     * @param naziv    the naziv
     */
    public void addNewUserSubject(String username, String naziv) {
        DaoFactory.usersSubjectsDao().addNewUserSubject(username, naziv);
    }

    /**
     * Search by username and subject boolean.
     *
     * @param username the username
     * @param subject  the subject
     * @return the boolean
     * @throws MyException the my exception
     */
    public boolean searchByUsernameAndSubject(String username, String subject) throws MyException {
        return DaoFactory.usersSubjectsDao().searchByUsernameAndSubject(username, subject);
    }

}
