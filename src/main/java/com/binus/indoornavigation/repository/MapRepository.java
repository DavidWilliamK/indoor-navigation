package com.binus.indoornavigation.repository;

import com.binus.indoornavigation.model.Maps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapRepository extends JpaRepository<Maps, Integer> {
    Optional<Maps> findById(Integer id);
}
