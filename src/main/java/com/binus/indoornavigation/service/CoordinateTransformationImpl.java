package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.Beacons;
import com.binus.indoornavigation.model.Signals;
import com.binus.indoornavigation.model.Coordinate;
import com.binus.indoornavigation.repository.ReferencePointDetailRepository;
import com.binus.indoornavigation.repository.ReferencePointRepository;
import com.binus.indoornavigation.repository.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinateTransformationImpl {

    @Autowired
    private SignalRepository signalRepository;

    @Autowired
    private ReferencePointRepository referencePointRepository;

    @Autowired
    private ReferencePointDetailRepository detailRepository;


    public List<Signals> getAllBeacons() {return signalRepository.findAll(); }

    public Coordinate getCoordinateFromBeacons (List<Beacons> beacons) {
        double coorX = 0.0;
        double coorY = 0.0;
        for (Beacons beacon : beacons) {
            System.out.println("BeaconID: " + beacon.getId() + ", Signal Strength: " + beacon.getRSSI() + "dB");

//            DEPRECATED
//            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//            Operation for X-axis
//            Note that this is still dummy function, thus it will only sum all signals's RSSI
//            coorX+= beacon.getRSSI();

//            Operation for Y-axis
//            Note that this is still dummy function, thus it will only sum all signals's RSSI
//            coorY+= beacon.getRSSI();
//            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//            DEPRECATED

            Optional<Signals> source = signalRepository.findTopByRSSIIsLessThanEqual(beacon.getRSSI());
            source.ifPresent(signals ->
                    System.out.println("Signal is nearest to reference point with id: " + signals.getReferencePointId())
            );

        }
        return new Coordinate(coorX, coorY);
    }

}
