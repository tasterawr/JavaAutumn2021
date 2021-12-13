package com.example.spring_data_lesson.repo;

import com.example.spring_data_lesson.model.Star;
import org.springframework.data.repository.CrudRepository;

public interface StarRepository extends CrudRepository<Star, Integer> {
}
