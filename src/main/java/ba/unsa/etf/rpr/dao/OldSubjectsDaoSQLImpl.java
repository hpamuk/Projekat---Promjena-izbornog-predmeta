package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.business.UserSubjectManager;
import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * MySQL Implementation of DAO
 * @author Hena Pamuk
 */
public class OldSubjectsDaoSQLImpl extends AbstractDao<OldSubject> implements OldSubjectsDao {
    private static  OldSubjectsDaoSQLImpl instance = null;

    private OldSubjectsDaoSQLImpl() {
        super("OldSubjects");
    }

    /**
     * Get instance old subjects dao sql.
     *
     * @return the old subjects dao sql
     */
    public static OldSubjectsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new OldSubjectsDaoSQLImpl();
        return instance;
    }

    /**
     * Remove instance.
     */
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
        row.put("profesor", object.getProfesor());
        row.put("brCasovaSemestralno", object.getBrCasovaSemestralno());
        row.put("brCasovaSedmicno", object.getBrCasovaSedmicno());
        return row;
    }

   @Override
   public OldSubject addOldSubject(NewSubject newSubjectToAdd) {
        // trazilo prebacivanje u OldSubject iz nekog razloga
        OldSubject oldSubject = new OldSubject();
        oldSubject.setId(newSubjectToAdd.getId());
        oldSubject.setProfesor(newSubjectToAdd.getProfesor());
        oldSubject.setBrCasovaSedmicno(newSubjectToAdd.getBrCasovaSedmicno());
        oldSubject.setNaziv(newSubjectToAdd.getNaziv());
        oldSubject.setBrCasovaSemestralno(newSubjectToAdd.getBrCasovaSemestralno());
        String query = "INSERT INTO OldSubjects (id,naziv,profesor,brCasovaSemestralno,brCasovaSedmicno) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, oldSubject.getId());
            preparedStatement.setString(2, oldSubject.getNaziv());
            preparedStatement.setString(3, oldSubject.getProfesor());
            preparedStatement.setInt(4, oldSubject.getBrCasovaSemestralno());
            preparedStatement.setInt(5, oldSubject.getBrCasovaSedmicno());
            preparedStatement.executeUpdate();
            return oldSubject;

        } catch (SQLException e) {
            System.out.println("Neki problem u radu sa novom funkcijom dodavanja starih predmeta!");
        }
        return null;
    }

    @Override
    public List<OldSubject> getOdgovarajuce(String username) throws MyException {
        UserSubjectManager userSubjectManager = new UserSubjectManager();
        List<UserSubject> listaOdabranih = userSubjectManager.getByUsername(username);
        List<OldSubject> svi = this.getAll();
        List<OldSubject> zaVracanje = new ArrayList<>();
        for (UserSubject u : listaOdabranih) {
            for (OldSubject o : svi) {
                if(u.getNaziv().equals(o.getNaziv()))
                    zaVracanje.add(o);
            }
        }
        return zaVracanje;
    }

}
