package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.*;
import com.binus.indoornavigation.repository.ReferencePointDetailRepository;
import com.binus.indoornavigation.repository.ReferencePointRepository;
import com.binus.indoornavigation.repository.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.Signal;

import java.util.*;

@Service
public class CoordinateTransformationImpl {

    @Autowired
    private SignalRepository signalRepository;

    @Autowired
    private ReferencePointRepository referencePointRepository;

    @Autowired
    private ReferencePointDetailRepository detailRepository;


    public List<Signals> getAllBeacons() {return signalRepository.findAll(); }

    public Coordinate getCoordinateFromBeacons (List<Beacons> request) {
//        How this part works:
        /*
        First you take the list of beacons obtained from the request
        Then sort the beacons based on signalStrength using the custom-made sort located on file "model/Beacons"
        Then use subList to take top 8 data
        Use those 8 beacons to retrieve their corresponding signals (Each beacon may have more than 1 signal)


         */

        double coorX = 0.0;
        double coorY = 0.0;
        ArrayList<Beacons> beacons = new ArrayList<Beacons>(request);
        Collections.sort(beacons);
        ArrayList<Beacons> strongestBeacons = new ArrayList<Beacons>(beacons.subList(0, 8));
        System.out.println("Top 8 signals: " + strongestBeacons);
        List<Signals> signals = new ArrayList<Signals>();
        for (Beacons source : strongestBeacons) {
            signals.addAll(signalRepository.findAllByBeaconIdAndRSSI(source.getId(), source.getRSSI()));
        }
        ArrayList<Double> distances = new ArrayList<Double>();
        for (Signals signal: signals) {
            ArrayList<Signals> testingData = new ArrayList<Signals>(signalRepository.findAllByReferencePointId(signal.getReferencePointId()));
            Collections.sort(testingData);
            double distance = 0.0;
            for (int idx = 0; idx < testingData.size(); idx++) {
                distance+= StrictMath.pow(request.get(idx).getRSSI() - testingData.get(idx).getRSSI(), 2);
            }
            distances.add(Math.sqrt(distance));
        }
        System.out.println(distances);
        System.out.println(distances.indexOf(Collections.min(distances)));
        System.out.println(signals.get(distances.indexOf(Collections.min(distances))).getReferencePointId());
        ReferencePointDetails detail = detailRepository.findByPointId(signals.get(distances.indexOf(Collections.min(distances))).getReferencePointId()).orElse(null);
        return new Coordinate((double)detail.getCoor_x(), (double)detail.getCoor_y());
    }

}
