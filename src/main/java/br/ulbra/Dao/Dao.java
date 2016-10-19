package br.ulbra.Dao;

import java.util.Collection;

/**
 * Created by Gabriel on 19/10/2016.
 */
public interface Dao<T> {

    void add(T obj);
    void delete(int id);
    Collection<T> getAll();
}
