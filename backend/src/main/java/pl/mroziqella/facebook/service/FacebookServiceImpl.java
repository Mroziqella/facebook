package pl.mroziqella.facebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mroziqella.facebook.exeption.NotFoundException;
import pl.mroziqella.facebook.exeption.NotImplementExeption;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.tools.FacebookRepository;

import java.util.Map;
import java.util.Set;

/**
 * Created by Mroziqella on 09.06.2017.
 */
public class FacebookServiceImpl implements FacebookService {

    @Autowired
    private FacebookRepository facebookRepository;

    @Override
    public Facebook findById(String id) throws NotFoundException {
        return facebookRepository.getById(id);
    }

    @Override
    public Map<String, Long> findMostCommonWords() {
        throw new NotImplementExeption();
    }

    @Override
    public Set<String> findPostIdsByKeyword(String word) {
        throw new NotImplementExeption();
    }

    @Override
    public Set<Facebook> findAll() {
        throw new NotImplementExeption();
    }
}
