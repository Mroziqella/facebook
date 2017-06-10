package pl.mroziqella.facebook.jobs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Mroziqella on 10.06.2017.
 */
@Configuration
class ConfigImport {

    @Bean
    @Profile(value = "production")
    ImportProfile importProfile(){
        return new ImportProfile(true);
    }

    @Bean
    ImportProfile importProfileTest(){
        return new ImportProfile(false);
    }
}
