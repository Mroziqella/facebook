package pl.mroziqella.facebook.tools;

import pl.mroziqella.facebook.model.Facebook;

/**
 * Created by Mroziqella on 08.06.2017.
 */
public interface FacebookRepository {

    void insert(Facebook facebook);

    Facebook getById(String id);

    int countElement();

}
