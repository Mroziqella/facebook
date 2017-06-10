package pl.mroziqella.facebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mroziqella.facebook.exeption.NotFoundException;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.model.Post;
import pl.mroziqella.facebook.repository.FacebookRepository;
import pl.mroziqella.facebook.repository.PostRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Mroziqella on 09.06.2017.
 */
@Service
class FacebookServiceImpl implements FacebookService {

    private FacebookRepository facebookRepository;
    private PostRepository postRepository;

    @Autowired
    public FacebookServiceImpl(FacebookRepository facebookRepository, PostRepository postRepository) {
        this.facebookRepository = facebookRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Facebook findById(String id) throws NotFoundException {
        Facebook facebookItem = facebookRepository.getById(id);
        if (facebookItem == null) {
            throw new NotFoundException();
        }
        return facebookItem;
    }

    @Override
    public Map<String, Long> findMostCommonWords() {
        Map<String, Long> commonWordsMap = new HashMap<>();
        postRepository.findAll().forEach(p -> {
            StringTokenizer st = new StringTokenizer(p.getMessage());
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                updateWordsCommonMap(token, commonWordsMap);
            }
        });
        return commonWordsMap;
    }


    @Override
    public Set<String> findPostIdsByKeyword(String word) {
        return postRepository.findAll().stream()
                .filter(p -> p.getMessage().matches(".*\\b" + word + "\\b.*"))
                .map(Post::getId).collect(Collectors.toSet());
    }

    @Override
    public Set<Facebook> findAll() {
        return new TreeSet<>(facebookRepository.findAll());
    }

    private void updateWordsCommonMap(String token, Map<String, Long> commonWordsMap) {
        token = token.replaceAll("[,.;/\\\\{}()><?!#$%^*'~`|:\\[\\]_]", "").toLowerCase().trim();
        if (token.equals("")) {
            return;
        }
        if (commonWordsMap.containsKey(token)) {
            commonWordsMap.put(token, commonWordsMap.get(token) + 1);
        } else {
            commonWordsMap.put(token, 1l);
        }
    }
}
