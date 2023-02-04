package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;


public class OldSubjectsDaoSQLImpl extends AbstractDao<OldSubject> implements OldSubjectsDao {
    private static  OldSubjectsDaoSQLImpl instance = null;
    private OldSubjectsDaoSQLImpl() {
        super("OldSubjects");
    }

    public static OldSubjectsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new OldSubjectsDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public OldSubject row2object(ResultSet rs) throws MyException {
        try {
            OldSubject cat = new OldSubject();
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
    public Map<String, Object> object2row(OldSubject object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("naziv", object.getNaziv());
        return row;
    }

}
