package pl.mroziqella.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mroziqella.facebook.exeption.NotFoundException;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.service.FacebookService;

import java.util.Set;

/**
 * Created by Mroziqella on 09.06.2017.
 */
@RestController
@RequestMapping("/api")
class FacebookController {
    @Autowired
    private FacebookService facebookService;


    @GetMapping("/getAll")
    private Set<Facebook> getAll(){
        Set<Facebook> all = facebookService.findAll();
        return all;
    }

    @GetMapping("/go/{id}")
    private Facebook getProfile(@PathVariable String id) throws NotFoundException {
        return facebookService.findById(id);
    }

}
