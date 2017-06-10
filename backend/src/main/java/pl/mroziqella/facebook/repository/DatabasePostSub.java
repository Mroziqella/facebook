package pl.mroziqella.facebook.repository;

import org.springframework.stereotype.Repository;
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
    public int countElement() {
        return POST_MAP.size();
    }

    @Override
    public Collection<Post> findAll() {
        return POST_MAP.values();
    }
}
