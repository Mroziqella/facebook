package pl.mroziqella.facebook.repository;

import org.springframework.stereotype.Repository;
import pl.mroziqella.facebook.exeption.InsertExeption;
import pl.mroziqella.facebook.model.Facebook;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Mroziqella on 08.06.2017.
 */
@Repository
class DatabaseStub implements FacebookRepository {
    private final static Map<String, Facebook> FACEBOOK_MAP = new TreeMap<>();

    @Override
    public void insert(Facebook facebook) {
        validation(facebook);
        FACEBOOK_MAP.put(facebook.getId(), facebook);
    }

    @Override
    public int countElement() {
        return FACEBOOK_MAP.size();
    }

    @Override
    public Facebook getById(String id) {
        return FACEBOOK_MAP.get(id);
    }

    private void validation(Facebook facebook){
        if (facebook.getId() == null) {
            throw new InsertExeption("Id is NULL!!!");
        }
        if(facebook.getId().trim().equals("")){
            throw new InsertExeption("Id is WRONG!!!");
        }
        if (FACEBOOK_MAP.containsKey(facebook.getId())) {
            throw new InsertExeption("Id existis!!!");
        }
    }

    @Override
    public Collection<Facebook> findAll() {
        return FACEBOOK_MAP.values();
    }
}
