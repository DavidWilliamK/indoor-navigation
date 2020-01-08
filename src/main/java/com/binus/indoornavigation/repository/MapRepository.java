package com.binus.indoornavigation.repository;

import com.binus.indoornavigation.model.Maps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Maps, Integer> {
    Maps findById();
}
