package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class UserManager {

    public List<User> getAll() throws MyException {
        return DaoFactory.usersDao().getAll();
    }

    public User getById(int userId) throws MyException{
        return DaoFactory.usersDao().getById(userId);
    }

    public void update(User q) throws MyException{
        DaoFactory.usersDao().update(q);
    }
}
