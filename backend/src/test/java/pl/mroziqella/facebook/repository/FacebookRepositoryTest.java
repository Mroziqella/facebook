package pl.mroziqella.facebook.repository;

import org.junit.Test;
import pl.mroziqella.facebook.exeption.InsertExeption;
import pl.mroziqella.facebook.model.Facebook;

/**
 * Created by Mroziqella on 08.06.2017.
 */
public class FacebookRepositoryTest {

    private FacebookRepository facebookRepository = new DatabaseStub();


    @Test(expected=InsertExeption.class)
    public void insertToDatabaseExeptionIdIsExistisTest(){
        Facebook facebook = new Facebook();
        facebook.setId("2");
        facebookRepository.insert(facebook);
        facebookRepository.insert(facebook);
    }

    @Test(expected=InsertExeption.class)
    public void insertToDatabaseExeptionIdIsNullTest(){
        Facebook facebook = new Facebook();
        facebook.setId(null);
        facebookRepository.insert(facebook);
    }

    @Test(expected=InsertExeption.class)
    public void insertToDatabaseExeptionIdIsEmptyTest(){
        Facebook facebook = new Facebook();
        facebook.setId("");
        facebookRepository.insert(facebook);
    }

    @Test(expected=InsertExeption.class)
    public void insertToDatabaseExeptionIdIsEmptySpaceTest(){
        Facebook facebook = new Facebook();
        facebook.setId("       ");
        facebookRepository.insert(facebook);
    }

}
