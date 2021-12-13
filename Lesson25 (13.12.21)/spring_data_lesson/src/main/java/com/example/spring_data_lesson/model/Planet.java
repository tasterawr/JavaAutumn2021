package com.example.spring_data_lesson.model;

import lombok.Data;

@Data
public class Planet {
    private Integer id;
    private String name;
    private Integer solarSystemId;
}
