package pl.mroziqella.facebook.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.mroziqella.facebook.exeption.NotFoundException;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.model.Post;
import pl.mroziqella.facebook.repository.FacebookRepository;

import java.util.*;

/**
 * Created by Mroziqella on 10.06.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class FacebookServiceTest {

    @Mock
    private FacebookRepository facebookRepository;
    private FacebookService facebookService;

    @Before
    public void init(){
        Map<String,Facebook> facebookMap = initMapWithData();


        Mockito.when(facebookRepository.getById("1")).thenReturn(facebookMap.get("1"));
        Mockito.when(facebookRepository.findAll()).thenReturn(initMapWithData().values());

        facebookService = new FacebookServiceImpl(facebookRepository);
    }


    @Test
    public void findByIdTest() throws NotFoundException {
        Facebook facebookUser = new Facebook();
        facebookUser.setId("1");
        facebookUser.setFirstname("Kamil");
        facebookUser.setLastname("Mroz");

        Facebook byId = facebookService.findById("1");

        Assert.assertEquals(facebookUser,byId);
    }

    @Test(expected=NotFoundException.class)
    public void findByIdExeptionTest() throws NotFoundException {
        facebookService.findById("5");

    }

    @Test
    public void findAllTest(){




        Set<Facebook> allFacebook = facebookService.findAll();


        Assert.assertEquals(initSortList().toArray(),allFacebook.toArray());

    }

    private List<Post> initPost(){
        List<Post> posts = new ArrayList<>();

        return null;
    }

    private List<Facebook> initSortList(){

        List<Facebook> facebooks = new ArrayList<>();
        Facebook fb1 = new Facebook();
        fb1.setId("1");
        fb1.setFirstname("Kamil");
        fb1.setLastname("Mroz");

        Facebook fb2 = new Facebook();
        fb2.setId("2");
        fb2.setFirstname("Artur");
        fb2.setLastname("Truchan");

        Facebook fb3 = new Facebook();
        fb3.setId("3");
        fb3.setFirstname("Kamil");
        fb3.setLastname("Gogol");

        Facebook fb4 = new Facebook();
        fb4.setId("4");
        fb4.setFirstname("Zenon");
        fb4.setLastname("Gogol");

        facebooks.add(fb2);
        facebooks.add(fb3);
        facebooks.add(fb1);
        facebooks.add(fb4);

        return facebooks;
    }

    private Map<String,Facebook> initMapWithData(){
        Map<String,Facebook> map = new HashMap<>();

        Facebook fb1 = new Facebook();
        fb1.setId("1");
        fb1.setFirstname("Kamil");
        fb1.setLastname("Mroz");

        Facebook fb2 = new Facebook();
        fb2.setId("2");
        fb2.setFirstname("Artur");
        fb2.setLastname("Truchan");

        Facebook fb3 = new Facebook();
        fb3.setId("3");
        fb3.setFirstname("Kamil");
        fb3.setLastname("Gogol");

        Facebook fb4 = new Facebook();
        fb4.setId("4");
        fb4.setFirstname("Zenon");
        fb4.setLastname("Gogol");

        map.put("1",fb1);
        map.put("2",fb2);
        map.put("3",fb3);
        map.put("4",fb4);

        return map;
    }
}
