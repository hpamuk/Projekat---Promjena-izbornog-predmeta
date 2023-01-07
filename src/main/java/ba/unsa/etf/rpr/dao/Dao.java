package ba.unsa.etf.rpr.dao;

//import ba.unsa.etf.rpr.exceptions.QuoteException;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;
/*
 Root interface for all DAO classes
 */

// dodaj dependencies za ovo

public interface Dao<T> {
    T getById(int id) throws MyException;
    T add(T item) throws MyException;
    T update(T item) throws MyException;
    void delete(int id) throws MyException;
    List<T> getAll() throws MyException;

}


