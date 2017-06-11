package pl.mroziqella.facebook.configuration;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

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
    @Bean
    ErrorViewResolver supportPathBasedLocationStrategyWithoutHashes() {
        return new ErrorViewResolver() {
            @Override
            public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
                return status == HttpStatus.NOT_FOUND
                        ? new ModelAndView("index.html", Collections.<String, Object>emptyMap(), HttpStatus.OK)
                        : null;
            }
        };
    }
}
