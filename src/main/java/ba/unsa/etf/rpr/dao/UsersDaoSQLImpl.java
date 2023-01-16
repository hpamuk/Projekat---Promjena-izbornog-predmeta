package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class UsersDaoSQLImpl extends AbstractDao<User> implements UsersDao{
    private static  UsersDaoSQLImpl instance = null;
    private UsersDaoSQLImpl() {
        super("Users");
    }

    public static UsersDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UsersDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

 /*   @Override
    public User add(User item) throws MyException {
        return null;
    }

    @Override
    public User update(User item) throws MyException {
        return null;
    }
*/
    @Override
    public User row2object(ResultSet rs) throws MyException {
        try {
            User cat = new User();
            cat.setId(rs.getInt("id"));
            cat.setImeIPrezime(rs.getString("colImeIPrezime"));
            return cat;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("colImeIPrezime", object.getImeIPrezime());
        return row;
    }


}
