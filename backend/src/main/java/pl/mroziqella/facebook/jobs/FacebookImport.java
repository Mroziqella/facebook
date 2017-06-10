package pl.mroziqella.facebook.jobs;

import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.model.Post;

import java.util.List;

/**
 * Created by Mroziqella on 10.06.2017.
 */
class FacebookImport extends Facebook {

    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
