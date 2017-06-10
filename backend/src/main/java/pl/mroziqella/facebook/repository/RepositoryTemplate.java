package pl.mroziqella.facebook.repository;

import pl.mroziqella.facebook.exeption.NotImplementExeption;

import java.util.Collection;

/**
 * Created by Mroziqella on 10.06.2017.
 */
public interface RepositoryTemplate<T> {

    default void insert(T object){
        throw new NotImplementExeption();
    }

    default T getById(String id){
        throw new NotImplementExeption();
    }

    default int countElement(){
        throw new NotImplementExeption();
    }

    default Collection<T> findAll(){
        throw new NotImplementExeption();
    }
}
