package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 * @author Hena Pamuk
 */
public class DaoFactory {

    private static final NewSubjectsDao newSubjectsDao =  NewSubjectsDaoSQLImpl.getInstance();
    private static final OldSubjectsDao oldSubjectsDao =  OldSubjectsDaoSQLImpl.getInstance();
    private static final UsersDao usersDao = UsersDaoSQLImpl.getInstance();
    private static final UsersSubjectsDao usersSubjectsDao = UsersSubjectsDaoSQLImpl.getInstance();

    private DaoFactory(){
    }

    /**
     * Users subjects dao users subjects dao.
     *
     * @return the users subjects dao
     */
    public static UsersSubjectsDao usersSubjectsDao(){
        return usersSubjectsDao;
    }

    /**
     * New subjects dao new subjects dao.
     *
     * @return the new subjects dao
     */
    public static NewSubjectsDao newSubjectsDao(){
        return newSubjectsDao;
    }

    /**
     * Old subjects dao old subjects dao.
     *
     * @return the old subjects dao
     */
    public static OldSubjectsDao oldSubjectsDao(){
        return oldSubjectsDao;
    }

    /**
     * Users dao users dao.
     *
     * @return the users dao
     */
    public static UsersDao usersDao(){
        return usersDao;
    }

}