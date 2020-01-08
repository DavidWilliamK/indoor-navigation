package com.binus.indoornavigation.repository;

import com.binus.indoornavigation.model.ReferencePoints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferencePointRepository extends JpaRepository<ReferencePoints, Integer> {
    ReferencePoints findById();
}
