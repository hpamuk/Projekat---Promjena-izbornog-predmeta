package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;


import java.util.List;

public interface UsersDao extends Dao<User>{
    public boolean searchByNameAndPassword();
}