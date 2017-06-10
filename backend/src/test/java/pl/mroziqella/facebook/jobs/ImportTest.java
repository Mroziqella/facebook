package pl.mroziqella.facebook.jobs;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mroziqella.facebook.configuration.Config;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.repository.FacebookRepository;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
public class ImportTest {

	@Autowired
	private ImportProfile importProfile;
	@Autowired
	private FacebookRepository facebookRepository;

	@Test
	public void countFileInDirectoryTest(){
		assertEquals(importProfile.fileCount(),2);
	}

	@Test
	public void importFile(){
		Facebook f1 = (Facebook) importProfile.importFromJsonFile("f1").get(Facebook.class);

		assertEquals("Luna",f1.getFirstname());
	}

	@Test
	public void importAllfromJsonFileTest(){
		importProfile.importAllfromJsonFile();

		assertEquals(2, facebookRepository.countElement());
		assertEquals("Kuna", facebookRepository.getById("2").getFirstname());
	}


}
