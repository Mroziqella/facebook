package pl.mroziqella.facebook.jobs;

import com.google.gson.Gson;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.model.Post;
import pl.mroziqella.facebook.repository.FacebookRepository;
import pl.mroziqella.facebook.repository.PostRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Mroziqella on 08.06.2017.
 */
@Service
class ImportProfile {

    @Autowired
    private Gson gson;
    @Autowired
    private FacebookRepository facebookRepository;
    @Autowired
    private PostRepository postRepository;

    Map<Type, Object> importFromJsonFile(String fileName) {
        BufferedReader jsonFile = new BufferedReader(
                new InputStreamReader(this.getClass()
                        .getResourceAsStream("/files/" + fileName + ".json")));

        FacebookImport facebookImport = gson.fromJson(jsonFile, FacebookImport.class);
        Facebook facebook = facebookImport;
        facebook.setPostsId(mapperListIdPost(facebookImport.getPosts()));

        return new HashMap<Type,Object>() {{
            put(Facebook.class, facebook);
            put(Post.class, facebookImport.getPosts());
        }};
    }

    void importAllfromJsonFile() {
        int fileCount = fileCount();
        for (int i = 1; i <= fileCount; i++) {
            Map<Type, Object> typeObjectMap = importFromJsonFile("f" + i);
            Facebook facebookItem = (Facebook) typeObjectMap.get(Facebook.class);

            facebookRepository.insert(facebookItem);

            List<Post> posts= (List<Post>)typeObjectMap.get(Post.class);
            posts.forEach(p->postRepository.insert(p));

        }
    }

    int fileCount() {
        return new File(getClass().getResource("/files").getPath()).list().length;
    }

    List<String> mapperListIdPost(List<Post> posts) {
        if (posts != null) {
            List<String> postsId = posts.stream()
                    .map(Post::getId)
                    .collect(Collectors.toList());
            return postsId;
        }
        return Collections.emptyList();
    }
}
