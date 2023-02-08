package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

/**
 * Root interface for all DAO classes
 * @author Hena Pamuk
 * @param <T> the type parameter
 */
public interface Dao<T> {

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     * @throws MyException the my exception
     */
    T getById(int id) throws MyException;

    /**
     * Add t.
     *
     * @param item the item
     * @return the t
     * @throws MyException the my exception
     */
    T add(T item) throws MyException;

    /**
     * Update t.
     *
     * @param item the item
     * @return the t
     * @throws MyException the my exception
     */
    T update(T item) throws MyException;

    /**
     * Delete.
     *
     * @param id the id
     * @throws MyException the my exception
     */
    void delete(int id) throws MyException;

    /**
     * Gets all.
     *
     * @return the all
     * @throws MyException the my exception
     */
    List<T> getAll() throws MyException;

}


