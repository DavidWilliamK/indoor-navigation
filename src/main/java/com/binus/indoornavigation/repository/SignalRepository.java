package com.binus.indoornavigation.repository;

import com.binus.indoornavigation.model.Signals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SignalRepository extends JpaRepository<Signals, Integer> {
    List<Signals> findAll();

    Optional<Signals> findById(Integer beaconId);
}
