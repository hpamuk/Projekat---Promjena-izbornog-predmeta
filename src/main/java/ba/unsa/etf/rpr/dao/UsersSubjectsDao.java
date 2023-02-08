package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

/**
 * Dao interface for UserSubject domain bean
 * @author Hena Pamuk
 */
public interface UsersSubjectsDao extends Dao<UserSubject>{

    /**
     * Gets by username.
     *
     * @param username the username
     * @return the by username
     * @throws MyException the my exception
     */
    public List<UserSubject> getByUsername(String username) throws MyException;

    /**
     * Delete by name.
     *
     * @param username the username
     * @param subject  the subject
     */
    public void deleteByName(String username, String subject);

    /**
     * Add new user subject.
     *
     * @param username the username
     * @param subject  the subject
     */
    public void addNewUserSubject(String username, String subject);

    /**
     * Search by username and subject boolean.
     *
     * @param username the username
     * @param subject  the subject
     * @return the boolean
     * @throws MyException the my exception
     */
    public boolean searchByUsernameAndSubject(String username, String subject) throws MyException;
}
