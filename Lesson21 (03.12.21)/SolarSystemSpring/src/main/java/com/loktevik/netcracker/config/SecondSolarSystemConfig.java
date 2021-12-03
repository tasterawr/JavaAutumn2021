package com.loktevik.netcracker.config;

import com.loktevik.netcracker.models.Planet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondSolarSystemConfig {

    @Bean
    public Planet planet(){
        return new Planet("Neptune");
    }
}
