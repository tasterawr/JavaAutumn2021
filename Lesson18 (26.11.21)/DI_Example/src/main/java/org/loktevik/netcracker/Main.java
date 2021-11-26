package org.loktevik.netcracker;

import org.loktevik.netcracker.config.FirstConfiguration;
import org.loktevik.netcracker.config.SecondConfiguration;
import org.loktevik.netcracker.models.Planet;
import org.loktevik.netcracker.models.SolarSystem;
import org.loktevik.netcracker.models.Star;

public class Main {

    public static void main(String[] args) {
        FirstConfiguration configuration1 = new FirstConfiguration();
        SecondConfiguration configuration2 = new SecondConfiguration();
        ApplicationContext context = new ApplicationContext();
        context.init(configuration1, configuration2);

        System.out.println(context.getBean(Planet.class));
        System.out.println(context.getBean(Star.class));

        SolarSystem solarSystem = new SolarSystem(
                context.getBean(Star.class),
                context.getBeans(Planet.class));

        System.out.println(solarSystem);
    }
}
