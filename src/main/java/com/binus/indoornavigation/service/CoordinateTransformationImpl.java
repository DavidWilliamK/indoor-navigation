package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.Beacon;
import com.binus.indoornavigation.model.Coordinate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinateTransformationImpl {

    public Coordinate getCoordinateFromBeacons (List<Beacon> beacons) {
        double coorX = 0.0;
        double coorY = 0.0;
        for (Beacon beacon : beacons) {
            System.out.println("BeaconID: " + beacon.getId() + ", Signal Strength: " + beacon.getSignalStrength() + "dB");

//            Operation for X-axis
//            Note that this is still dummy function, thus it will only sum all beacon's RSSI
            coorX+= beacon.getSignalStrength();

//            Operation for Y-axis
//            Note that this is still dummy function, thus it will only sum all beacon's RSSI
            coorY+= beacon.getSignalStrength();

        }
        return new Coordinate(coorX, coorY);
    }

}
