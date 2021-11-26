package org.loktevik.netcracker.config;

import org.loktevik.netcracker.annotations.Bean;
import org.loktevik.netcracker.models.Planet;
import org.loktevik.netcracker.models.Star;

public class FirstConfiguration implements Configuration{

    @Bean
    public Star star(){
        return new Star("Sun");
    }

    @Bean
    public Planet planet1(){
        return new Planet("Earth");
    }

    @Bean
    public Planet planet2(){
        return new Planet("Mercury");
    }
}
