package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class NewSubjectsDaoSQLImpl extends AbstractDao<NewSubject> implements NewSubjectsDao{
    private static  NewSubjectsDaoSQLImpl instance = null;

    private NewSubjectsDaoSQLImpl() {
        super("NewSubjects");
    }

    public static NewSubjectsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new NewSubjectsDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public NewSubject row2object(ResultSet rs) throws MyException {
        try {
            NewSubject cat = new NewSubject();
            cat.setId(rs.getInt("id"));
            cat.setNaziv(rs.getString("naziv"));
            cat.setProfesor(rs.getString("profesor"));
            cat.setBrCasovaSemestralno(rs.getInt("brCasovaSemestralno"));
            cat.setBrCasovaSedmicno(rs.getInt("brCasovaSedmicno"));
            return cat;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(NewSubject object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("naziv", object.getNaziv());
        row.put("profesor", object.getProfesor());
        row.put("brCasovaSemestralno", object.getBrCasovaSemestralno());
        row.put("brCasovaSedmicno", object.getBrCasovaSedmicno());
        return row;
    }
}
