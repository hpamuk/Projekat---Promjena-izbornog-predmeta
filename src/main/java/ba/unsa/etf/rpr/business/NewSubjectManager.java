package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

/**
 *  Business Logic Layer for management of NewSubjects
 *  @author Hena Pamuk
 */
public class NewSubjectManager {

    /**
     * Gets all.
     *
     * @return the all
     * @throws MyException the my exception
     */
    public List<NewSubject> getAll() throws MyException {
        return DaoFactory.newSubjectsDao().getAll();
    }

    /**
     * Gets by id.
     *
     * @param userId the user id
     * @return the by id
     * @throws MyException the my exception
     */
    public NewSubject getById(int userId) throws MyException{
        return DaoFactory.newSubjectsDao().getById(userId);
    }

    /**
     * Update.
     *
     * @param q the q
     * @throws MyException the my exception
     */
    public void update(NewSubject q) throws MyException{
        DaoFactory.newSubjectsDao().update(q);
    }

}
