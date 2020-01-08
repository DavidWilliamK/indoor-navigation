package com.binus.indoornavigation.repository;

import com.binus.indoornavigation.model.ReferencePoints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferencePointRepository extends JpaRepository<ReferencePoints, Integer> {
    Optional<ReferencePoints> findById(Integer id);
}
