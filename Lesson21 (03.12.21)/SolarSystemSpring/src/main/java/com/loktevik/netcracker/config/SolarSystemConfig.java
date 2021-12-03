package com.loktevik.netcracker.config;

import com.loktevik.netcracker.models.Planet;
import com.loktevik.netcracker.models.SolarSystem;
import com.loktevik.netcracker.models.Star;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SolarSystemConfig {

    @Bean
    public Planet planet1(){
        return new Planet("Earth");
    }

    @Bean
    public Planet planet2(){
        return new Planet("Saturn");
    }

    @Bean
    public Planet planet3(){
        return new Planet("Jupiter");
    }

    @Bean
    public Star star1(){
        return new Star("Sun");
    }

//    @Bean
//    public List<Planet> planets(Planet planet1, Planet planet2){
//        List<Planet> planets = new ArrayList<>();
//        planets.add(planet1);
//        planets.add(planet2);
//        return planets;
//    }

    @Bean
    public SolarSystem solarSystem(Star star, List<Planet> planets){
        return new SolarSystem(star, planets);
    }
}
