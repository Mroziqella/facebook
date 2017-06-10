package pl.mroziqella.facebook.jobs;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mroziqella.facebook.configuration.Config;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.model.Post;
import pl.mroziqella.facebook.repository.FacebookRepository;
import pl.mroziqella.facebook.repository.PostRepository;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@ActiveProfiles(profiles = "test")
public class ImportTest {

	@Autowired
	private ImportProfile importProfile;
	@Autowired
	private FacebookRepository facebookRepository;
	@Autowired
	private PostRepository postRepository;

	@Test
	public void countFileInDirectoryTest(){
		assertEquals(importProfile.filesCount(),2);
	}

	@Test
	public void importFile(){
		Map<Type, Object> map = importProfile.importFromJsonFile("f1");
		Facebook facebookItem = (Facebook) map.get(Facebook.class);

		List<Post> posts = (List<Post>) map.get(Post.class);

		assertEquals("Luna",facebookItem.getFirstname());
		assertEquals("Beautiful picture. Curve is nice if you sit within The radius. Nice interface. Enjoyable to watch TV and YouTube as well Netflix. Like the voice recognition software.",posts.get(0).getMessage());
		assertEquals(3,posts.size());
	}

	@Test
	public void importAllfromJsonFileTest(){
		importProfile.importAllfromJsonFile();

		assertEquals(2, facebookRepository.countElement());
		assertEquals("Kuna", facebookRepository.getById("2").getFirstname());
		assertEquals(6,postRepository.countElement());

	}


}
