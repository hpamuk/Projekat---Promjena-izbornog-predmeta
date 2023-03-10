package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Hena Pamuk
 */
public class UsersDaoSQLImpl extends AbstractDao<User> implements UsersDao {
    private static UsersDaoSQLImpl instance = null;

    private UsersDaoSQLImpl() {
        super("Users");
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static UsersDaoSQLImpl getInstance() {
        if (instance == null)
            instance = new UsersDaoSQLImpl();
        return instance;
    }

    /**
     * Remove instance.
     */
    public static void removeInstance() {
        if (instance != null)
            instance = null;
    }

    @Override
    public User row2object(ResultSet rs) throws MyException {
        try {
            User cat = new User();
            cat.setId(rs.getInt("id"));
            cat.setImeIPrezime(rs.getString("username"));
            cat.setBrIndeksa(rs.getString("brIndeksa"));
            return cat;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("username", object.getImeIPrezime());
        return row;
    }

    @Override
    public boolean searchByName(String username, String password) throws MyException {
        //  String query = "SELECT * FROM Users WHERE username = ? AND brIndeksa = ?";
        List<User> svi = this.getAll();
        for (User u : svi) {
            if(u.getImeIPrezime().equals(username) && u.getBrIndeksa().equals(password))
                return true;
        }
        return false;
    }

}