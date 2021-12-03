package com.loktevik.netcracker;


import com.loktevik.netcracker.config.SecondSolarSystemConfig;
import com.loktevik.netcracker.config.SolarSystemConfig;
import com.loktevik.netcracker.models.Planet;
import com.loktevik.netcracker.models.SolarSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SolarSystemConfig.class, SecondSolarSystemConfig.class);
        System.out.println(context.getBean("planet1", Planet.class));
        System.out.println(context.getBean("solarSystem", SolarSystem.class));
    }
}
