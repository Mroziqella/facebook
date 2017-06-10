package pl.mroziqella.facebook.configuration;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mroziqella on 08.06.2017.
 */
@Configuration
@ComponentScan("pl.mroziqella.facebook.*")
public class Config {

    @Bean
    Gson gson(){
        return new Gson();
    }
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
