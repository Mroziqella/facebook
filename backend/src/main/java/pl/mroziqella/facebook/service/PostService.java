package pl.mroziqella.facebook.service;

import pl.mroziqella.facebook.model.Post;

/**
 * Created by Mroziqella on 11.06.2017.
 */
public interface PostService {
    Post findById(String id);

}
