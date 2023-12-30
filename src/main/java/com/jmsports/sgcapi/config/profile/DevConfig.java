package com.jmsports.sgcapi.config.profile;

import com.jmsports.sgcapi.services.DbService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@AllArgsConstructor
@Profile("dev")
public class DevConfig {

    private final DbService dbService;

    @Bean
    public boolean instantiateDatabase() {
        dbService.add();
        return true;
    }

}