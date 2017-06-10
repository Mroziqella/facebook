package pl.mroziqella.facebook.repository;

import pl.mroziqella.facebook.model.Facebook;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Mroziqella on 08.06.2017.
 */
public interface FacebookRepository {

    void insert(Facebook facebook);

    Facebook getById(String id);

    int countElement();

    Collection<Facebook> findAll();
}
