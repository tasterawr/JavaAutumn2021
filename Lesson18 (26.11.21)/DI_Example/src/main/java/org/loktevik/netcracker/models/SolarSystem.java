package org.loktevik.netcracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolarSystem {
    private Star star;
    private List<Planet> planets;

    @Override
    public String toString() {
        return "SolarSystem{" +
                "star=" + star +
                ", planets=" + planets +
                '}';
    }
}
