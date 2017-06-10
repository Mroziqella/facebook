package pl.mroziqella.facebook.repository;

import org.springframework.stereotype.Repository;
import pl.mroziqella.facebook.exeption.InsertExeption;
import pl.mroziqella.facebook.exeption.NotImplementExeption;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Mroziqella on 08.06.2017.
 */
@Repository
class DatabasePostSub implements PostRepository {

    private final static Map<String, Post> POST_MAP = new TreeMap<>();

    @Override
    public void insert(Post post) {
        POST_MAP.put(post.getId(),post);
    }


    @Override
    public Post getById(String id) {
        throw new NotImplementExeption();
    }

    @Override
    public int countElement() {
        throw new NotImplementExeption();
    }

    @Override
    public Collection<Post> findAll() {
        throw new NotImplementExeption();
    }
}
