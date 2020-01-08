package com.binus.indoornavigation.repository;

import com.binus.indoornavigation.model.ReferencePointDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferencePointDetailRepository extends JpaRepository<ReferencePointDetails, Integer> {
    Optional<ReferencePointDetails> findById(Integer id);
}
