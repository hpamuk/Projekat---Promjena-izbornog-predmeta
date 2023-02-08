package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

/**
 * Dao interface for OldSubject domain bean
 * @author Hena Pamuk
 */
public interface OldSubjectsDao extends Dao<OldSubject> {

    /**
     * Add old subject old subject.
     *
     * @param oldSubject the old subject
     * @return the old subject
     */
    public OldSubject addOldSubject(OldSubject oldSubject);

    /**
     * Gets odgovarajuce.
     *
     * @param username the username
     * @return the odgovarajuce
     * @throws MyException the my exception
     */
    public List<OldSubject> getOdgovarajuce(String username) throws MyException;

}

