package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.Signals;
import com.binus.indoornavigation.model.Coordinate;
import com.binus.indoornavigation.repository.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinateTransformationImpl {

    @Autowired
    private SignalRepository signalRepository;

    public List<Signals> getAllBeacons() {return signalRepository.findAll(); }

    public Coordinate getCoordinateFromBeacons (List<Signals> signals) {
        double coorX = 0.0;
        double coorY = 0.0;
        for (Signals signal : signals) {
            System.out.println("BeaconID: " + signal.getId() + ", Signal Strength: " + signal.getRSSI() + "dB");

//            Operation for X-axis
//            Note that this is still dummy function, thus it will only sum all signals's RSSI
            coorX+= signal.getRSSI();

//            Operation for Y-axis
//            Note that this is still dummy function, thus it will only sum all signals's RSSI
            coorY+= signal.getRSSI();

        }
        return new Coordinate(coorX, coorY);
    }

}
