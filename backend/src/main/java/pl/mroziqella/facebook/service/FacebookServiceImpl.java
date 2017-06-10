package pl.mroziqella.facebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mroziqella.facebook.exeption.NotFoundException;
import pl.mroziqella.facebook.exeption.NotImplementExeption;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.repository.FacebookRepository;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Mroziqella on 09.06.2017.
 */
@Service
class FacebookServiceImpl implements FacebookService {

    private FacebookRepository facebookRepository;

    @Autowired
    public FacebookServiceImpl(FacebookRepository facebookRepository) {
        this.facebookRepository = facebookRepository;
    }

    @Override
    public Facebook findById(String id) throws NotFoundException {
        Facebook facebookItem = facebookRepository.getById(id);
        if(facebookItem==null){
            throw new NotFoundException();
        }
        return facebookItem ;
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
        return new TreeSet<>(facebookRepository.findAll());
    }
}
