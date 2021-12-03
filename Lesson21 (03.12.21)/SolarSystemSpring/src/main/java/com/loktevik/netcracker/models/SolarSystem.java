package com.loktevik.netcracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolarSystem {
    private Star star;
    private List<Planet> planets;
}
