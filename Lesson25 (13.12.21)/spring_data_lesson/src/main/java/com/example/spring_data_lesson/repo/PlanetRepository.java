package com.example.spring_data_lesson.repo;

import com.example.spring_data_lesson.model.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository<Planet, Integer> {

}
