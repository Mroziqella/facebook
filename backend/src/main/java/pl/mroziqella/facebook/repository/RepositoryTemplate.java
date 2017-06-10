package pl.mroziqella.facebook.repository;

import pl.mroziqella.facebook.model.Facebook;

import java.util.Collection;

/**
 * Created by Mroziqella on 10.06.2017.
 */
public interface RepositoryTemplate<T> {

    void insert(T object);

    T getById(String id);

    int countElement();

    Collection<T> findAll();
}
