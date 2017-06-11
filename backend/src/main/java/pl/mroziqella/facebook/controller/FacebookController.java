package pl.mroziqella.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mroziqella.facebook.exeption.NotFoundException;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.model.Post;
import pl.mroziqella.facebook.service.FacebookService;
import pl.mroziqella.facebook.service.PostService;

import java.util.Map;
import java.util.Set;

/**
 * Created by Mroziqella on 09.06.2017.
 */
@RestController
@RequestMapping("/api")
class FacebookController {
    @Autowired
    private FacebookService facebookService;
    @Autowired
    private PostService postService;


    @GetMapping("/getAll")
    private Set<Facebook> getAll(){
        return facebookService.findAll();
    }

    @GetMapping("/go/{id}")
    private Facebook getProfile(@PathVariable String id) throws NotFoundException {
        return facebookService.findById(id);
    }

    @GetMapping("/getWords")
    private Map<String,Long> getWords() {
        return facebookService.findMostCommonWords();
    }

    @GetMapping("/search")
    private Set<String> searchWord(@RequestParam String word){
        return facebookService.findPostIdsByKeyword(word);
    }

    @GetMapping("/post")
    private Post getPost(@RequestParam String id){
        return postService.findById(id);
    }
}
