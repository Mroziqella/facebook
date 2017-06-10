package pl.mroziqella.facebook.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mroziqella on 08.06.2017.
 */
@Configuration
public class ConfigDatabase {
    @Bean
    FacebookRepository database(){
        return new DatabaseStub();
    }
}
