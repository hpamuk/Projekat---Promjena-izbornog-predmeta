package ba.unsa.etf.rpr.dao;

/*
 * Factory method for singleton implementation of DAOs
 */


public class DaoFactory {

    private static final NewSubjectsDao newSubjectsDao =  NewSubjectsDaoSQLImpl.getInstance();
    private static final OldSubjectsDao oldSubjectsDao =  OldSubjectsDaoSQLImpl.getInstance();
    private static final UsersDao usersDao = UsersDaoSQLImpl.getInstance();

    private DaoFactory(){
    }

    public static NewSubjectsDao newSubjectsDao(){
        return newSubjectsDao;
    }

    public static OldSubjectsDao oldSubjectsDao(){
        return oldSubjectsDao;
    }

    public static UsersDao usersDao(){
        return usersDao;
    }

}