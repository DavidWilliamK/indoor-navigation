package com.binus.indoornavigation.repository;

import com.binus.indoornavigation.model.ReferencePointDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferencePointDetailRepository extends JpaRepository<ReferencePointDetails, Integer> {
    ReferencePointDetails findById();
}
