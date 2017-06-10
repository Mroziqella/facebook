package pl.mroziqella.facebook.jobs;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.model.Post;
import pl.mroziqella.facebook.repository.FacebookRepository;
import pl.mroziqella.facebook.repository.PostRepository;

import javax.annotation.PostConstruct;
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
class ImportProfile {

    @Autowired
    private Gson gson;
    @Autowired
    private FacebookRepository facebookRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;

    private final Boolean isProduction;

    public ImportProfile(Boolean isProduction) {
        this.isProduction = isProduction;
    }

    Map<Type, Object> importFromJsonFile(String fileName) {
        FacebookImportModel facebookImport = gson.fromJson(readJsonFile(fileName), FacebookImportModel.class);

        List<Post> posts = facebookImport.getPosts();
        Facebook facebook = modelMapper.map(facebookImport,Facebook.class);
        facebook.setPostsId(mapperListIdsPost(posts));

        return new HashMap<Type,Object>() {{
            put(Facebook.class, facebook);
            put(Post.class, facebookImport.getPosts());
        }};
    }

    @PostConstruct
    private void init(){
        if(isProduction) {
            importAllfromJsonFile();
        }
    }

    void importAllfromJsonFile() {
        int fileCount = filesCount();
        for (long i = 1; i <= fileCount; i++) {
            Map<Type, Object> typeObjectMap = importFromJsonFile(buildFileName(i));
            Facebook facebookItem = (Facebook) typeObjectMap.get(Facebook.class);

            facebookRepository.insert(facebookItem);

            List<Post> posts= (List<Post>)typeObjectMap.get(Post.class);

            posts.forEach(p->postRepository.insert(p));

        }
    }

    private BufferedReader readJsonFile(String fileName){
        return new BufferedReader(
                new InputStreamReader(this.getClass()
                        .getResourceAsStream("/files/" + fileName + ".json")));
    }

   private String buildFileName(Long number){
        return "f" + number;
    }

    int filesCount() {
        return new File(getClass().getResource("/files").getPath()).list().length;
    }

    private List<String> mapperListIdsPost(List<Post> posts) {
        if (posts != null) {
            List<String> postsIds = posts.stream()
                    .map(Post::getId)
                    .collect(Collectors.toList());
            return postsIds;
        }
        return Collections.emptyList();
    }
}
