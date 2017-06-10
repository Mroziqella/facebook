package pl.mroziqella.facebook.jobs;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mroziqella.facebook.model.Facebook;
import pl.mroziqella.facebook.tools.FacebookRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Mroziqella on 08.06.2017.
 */
@Service
class ImportProfile {

    @Autowired
    private Gson gson;
    @Autowired
    private FacebookRepository facebookRepository;

     Facebook importFromJsonFile(String fileName) {
        BufferedReader jsonFile = new BufferedReader(
                new InputStreamReader(this.getClass()
                        .getResourceAsStream("/files/" + fileName + ".json")));

        return gson.fromJson(jsonFile, Facebook.class);
    }

     void importAllfromJsonFile() {
        int fileCount = fileCount();
        for (int i = 1; i <= fileCount; i++) {
            facebookRepository.insert(importFromJsonFile("f" + i));
        }
    }

     int fileCount() {
        return new File(getClass().getResource("/files").getPath()).list().length;
    }

}
