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
import pl.mroziqella.facebook.repository.PostRepository;

import java.util.*;

/**
 * Created by Mroziqella on 10.06.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class FacebookServiceTest {

    @Mock
    private FacebookRepository facebookRepository;
    @Mock
    private PostRepository postRepository;
    private FacebookService facebookService;

    @Before
    public void init(){
        Map<String,Facebook> facebookMap = initMapWithData();


        Mockito.when(facebookRepository.getById("1")).thenReturn(facebookMap.get("1"));
        Mockito.when(facebookRepository.findAll()).thenReturn(initMapWithData().values());
        Mockito.when(postRepository.findAll()).thenReturn(initPost());


        facebookService = new FacebookServiceImpl(facebookRepository,postRepository);
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

    @Test
    public void findPostIdsByKeywordTest(){

        Set<String> idsPost = facebookService.findPostIdsByKeyword("ipsum");

        Assert.assertEquals(2,idsPost.size());
        Assert.assertEquals(true,idsPost.contains("1"));
        Assert.assertEquals(true,idsPost.contains("3"));
    }
    @Test
    public void findPostIdsByKeywordSize0Test(){
        Set<String> idsPost = facebookService.findPostIdsByKeyword("yrty");

        Assert.assertEquals(0,idsPost.size());

    }

    @Test
    public void findPostIdsByKeywordSizeFirstTest(){
        Set<String> idsPost = facebookService.findPostIdsByKeyword("Lorem");

        Assert.assertEquals(true,idsPost.contains("1"));

    }

    @Test
    public void findMostCommonWordsTest(){
        List<Post> posts = new ArrayList<>();

        Post p1 = new Post();
        p1.setId("1");
        p1.setMessage("Lorem ipsum dolor sitt ipsum, lorem lorem ipsum [][:.<><.l ;/\\");
        posts.add(p1);
        Post p2 = new Post();
        p2.setId("2");
        p2.setMessage("Lorem ,.,.,)()_)((*(%%#%$#%#$ ipsum");
        posts.add(p2);


        Mockito.when(postRepository.findAll()).thenReturn(posts);

        Map<String, Long> mostCommonWords = facebookService.findMostCommonWords();

        Map<String, Long> templateMap = new HashMap<>();
        templateMap.put("ipsum",4l);
        templateMap.put("dolor",1l);
        templateMap.put("sitt",1l);
        templateMap.put("lorem",4l);
        templateMap.put("l",1l);

        Assert.assertEquals(templateMap,mostCommonWords);
    }

    private List<Post> initPost(){
        List<Post> posts = new ArrayList<>();
        Post p1 = new Post();
        p1.setId("1");
        p1.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis nisi ut ipsum lobortis aliquet. Quisque sed elementum tortor. Morbi vestibulum elit dui, sed ultricies urna gravida nec. Morbi luctus libero at mattis consectetur. Mauris vulputate nulla vitae lobortis consequat. Sed eleifend, sem et interdum sodales,");

        Post p2 = new Post();
        p2.setId("2");
        p2.setMessage("Mauris vitae lorem ac sem congue vestibulum. Cras non nunc rutrum, maximus dui at, dictum magna. Morbi rhoncus bibendum ullamcorper. Morbi sit amet nibh aliquam, lobortis nisl nec, semper felis. Suspendisse elementum quam sem, vitae cursus velit tincidunt at. Aenean dapibus malesuada nulla, id pharetra libero posuere quis. Suspendisse cursus varius metus, ut luctus enim blandit quis. Donec eget dictum enim, id tincidunt nisl.");

        Post p3 = new Post();
        p3.setId("3");
        p3.setMessage("Etiam lobortis diam ac sem ipsum, non maximus enim pulvinar. Pellentesque lectus quam, efficitur a faucibus id, pretium ut arcu. Nam et lorem sed leo facilisis semper.");

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);

        return posts;
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
