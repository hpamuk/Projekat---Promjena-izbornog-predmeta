package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reason;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class ReasonsDaoSQLImpl extends AbstractDao<Reason> implements ReasonsDao {
    private static  ReasonsDaoSQLImpl instance = null;
    private ReasonsDaoSQLImpl() {
        super("oldSubject"); // ????? vidi kako se zove
    }

    public static ReasonsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ReasonsDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Reason add(Reason item) throws MyException {
        return null;
    }

    @Override
    public Reason update(Reason item) throws MyException {
        return null;
    }

   @Override
    public Reason row2object(ResultSet rs) throws MyException {
        try {
            Reason cat = new Reason();
            cat.setId(rs.getInt("id"));
            cat.setNaziv(rs.getString("name"));
            return cat;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Reason object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("name", object.getNaziv());
        return row;
    }


}
