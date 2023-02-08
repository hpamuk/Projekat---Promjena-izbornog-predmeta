package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.ArrayList;
import java.util.List;

/**
 *  Business Logic Layer for management of OldSubjects
 *  @author Hena Pamuk
 */
public class OldSubjectManager {

    /**
     * Gets all.
     *
     * @return the all
     * @throws MyException the my exception
     */
    public List<OldSubject> getAll() throws MyException {
        return DaoFactory.oldSubjectsDao().getAll();
    }

    /**
     * Gets by id.
     *
     * @param oldSubjectId the old subject id
     * @return the by id
     * @throws MyException the my exception
     */
    public OldSubject getById(int oldSubjectId) throws MyException{
        return DaoFactory.oldSubjectsDao().getById(oldSubjectId);
    }

    /**
     * Update.
     *
     * @param q the q
     * @throws MyException the my exception
     */
    public void update(OldSubject q) throws MyException{
        DaoFactory.oldSubjectsDao().update(q);
    }

    /**
     * Gets odgovarajuce.
     *
     * @param username the username
     * @return the odgovarajuce
     * @throws MyException the my exception
     */
    public List<OldSubject> getOdgovarajuce(String username) throws MyException {
        return DaoFactory.oldSubjectsDao().getOdgovarajuce(username);
    }

    /**
     * Add.
     *
     * @param o the o
     */
    public void add(OldSubject o) {
        DaoFactory.oldSubjectsDao().addOldSubject(o);
    }

}
