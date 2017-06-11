package pl.mroziqella.facebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mroziqella.facebook.model.Post;
import pl.mroziqella.facebook.repository.PostRepository;

/**
 * Created by Mroziqella on 11.06.2017.
 */
@Service
class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post findById(String id) {
        return postRepository.getById(id);
    }
}
