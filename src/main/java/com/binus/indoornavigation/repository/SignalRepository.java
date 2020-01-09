package com.binus.indoornavigation.repository;

import com.binus.indoornavigation.model.Signals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SignalRepository extends JpaRepository<Signals, Integer> {
    List<Signals> findAll();

    Optional<Signals> findById(Integer beaconId);

    List<Signals> findAllByBeaconIdAndRSSI(String beaconId, Double rssi);

    List<Signals> findAllByReferencePointId(Integer id);

    Optional<Signals> findTopByRSSIIsLessThanEqual(Double rssi);

    Optional<Signals> findTopByRSSIGreaterThanEqualAndAndBeaconId(Integer beaconId, Double rssi);

//    TODO: Make a custom method to get the closest signals based on sorted value of RSSI
}
