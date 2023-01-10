package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.util.Map;

public class NewSubjectsDaoSQLImpl extends AbstractDao<NewSubject> implements NewSubjectsDao{
    private static  NewSubjectsDao instance = null;
    private NewSubjectsDaoSQLImpl() {
        super("newSubject"); // ????? vidi kako se zove
    }

    public static NewSubjectsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new NewSubjectsDaoSQLImpl();
        return (NewSubjectsDaoSQLImpl) instance; // sto je trazilo castovanje
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public NewSubject row2object(ResultSet rs) throws MyException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(NewSubject object) {
        return null;
    }
}
