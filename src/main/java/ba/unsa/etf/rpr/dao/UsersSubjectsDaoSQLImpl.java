package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UsersSubjectsDaoSQLImpl extends AbstractDao<UserSubject> implements UsersSubjectsDao {
    private static  UsersSubjectsDaoSQLImpl instance = null;
    private UsersSubjectsDaoSQLImpl() {
        super("users_subjects");
    }

    public static UsersSubjectsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UsersSubjectsDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public UserSubject row2object(ResultSet rs) throws MyException {
        try {
            UserSubject cat = new UserSubject();
            cat.setUsername(rs.getString("username"));
            cat.setNaziv(rs.getString("naziv"));
            return cat;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(UserSubject object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("username", object.getUsername());
        row.put("naziv", object.getNaziv());
        return row;
    }


    public List<UserSubject> getByUsername(String username) throws MyException {

        return executeQuery("SELECT * FROM users_subjects WHERE username = ?", new Object[]{username});
    }

    @Override
    public void deleteByName(String username, String subject) {
        String query = "DELETE FROM users_subjects WHERE username = ? AND naziv = ?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, subject);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Neki problem kod brisanja usera");
            e.printStackTrace();
        }

    }

    @Override
    public void addNewUserSubject(String username, String subject) {
        String query = "INSERT INTO users_subjects(username, naziv) VALUES(?,?)";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,username);
            stmt.setString(2, subject);

            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
