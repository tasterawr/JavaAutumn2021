package org.loktevik.netcracker.config;

import org.loktevik.netcracker.annotations.Bean;
import org.loktevik.netcracker.models.Planet;

public class SecondConfiguration implements Configuration {

    @Bean
    public Planet planet1(){
        return new Planet("Jupiter");
    }

    @Bean
    public Planet planet2(){
        return new Planet("Saturn");
    }
}
