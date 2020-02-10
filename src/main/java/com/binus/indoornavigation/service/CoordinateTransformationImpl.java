package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.*;
import com.binus.indoornavigation.repository.ReferencePointRepository;
import com.binus.indoornavigation.repository.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoordinateTransformationImpl {

    @Autowired
    private SignalRepository signalRepository;

    @Autowired
    private ReferencePointRepository referencePointRepository;


    public List<Signals> getAllBeacons() {return signalRepository.findAll(); }

    public Coordinate getCoordinateFromBeacons (List<Beacons> request) {
        double coorX = 0.0;
        double coorY = 0.0;
        ArrayList<Beacons> beacons = new ArrayList<Beacons>(request);
        Collections.sort(beacons); //Sort the beacon using custom sort based on signal strength
        int size = 8;
        if (request.size() < size)
            size = request.size();
        ArrayList<Beacons> strongestBeacons = new ArrayList<Beacons>(beacons.subList(0, size)); //Take 8 strongest
        Set<Integer> references = new HashSet<>(); //ReferencePointID
        ArrayList<String> ids = new ArrayList<>();
        for (Beacons beacon:strongestBeacons) {
            ids.add(beacon.getId());
        }
        List<Signals> rps = signalRepository.findAllByBeaconIdIn(ids);
        for (Beacons source : strongestBeacons) {
//            List<Signals> temp = signalRepository.findAllByBeaconId(source.getId());
            for (Signals s : rps) {
                references.add(s.getReferencePointId());
            }
        }
        System.out.println(references);
        SortedSet<Beacons> distances = new TreeSet<>(Collections.reverseOrder()); //Set of {ReferencePointId, Distance to query}
//        Loop 155
        ArrayList<Signals> datas = new ArrayList<Signals>(signalRepository.findAllByReferencePointIdIn(references));
        System.out.println(System.currentTimeMillis());
        for (Integer reference: references) {
            ArrayList<Signals> testingData = new ArrayList<>();
            for (Signals data: datas) {
                if (data.getReferencePointId().equals(reference)) {
                    testingData.add(data);
                }
            }
            Collections.sort(testingData);
            double distance = 0.0;
//            Loop 23
            for (int idx = 0; idx < request.size(); idx++) {
//                Loop 23
                for (int i = 0; i < testingData.size(); i++) {
                    if (testingData.get(i).getBeaconId().equals(request.get(idx).getId())) {
                        try {
                            distance+= StrictMath.pow(request.get(idx).getRSSI() - testingData.get(idx).getRSSI(), 2);
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            distance+=0;
                        }
                    }
                }
            }
            Beacons temp = new Beacons(reference.toString(), distance);
            distances.add(temp);
        }
        System.out.println(System.currentTimeMillis());
        int closest = 5;
        if (distances.size() < 5)
            closest = distances.size();
        List<Beacons> closestDistances = new ArrayList<Beacons>(new ArrayList<Beacons>(distances).subList(0, closest)); //5 closest referencePoints


        List<ReferencePoints> details = new ArrayList<>();
        for (Beacons distance : closestDistances) {
            details.add(referencePointRepository.findById(Integer.parseInt(distance.getId())).get());
        }

        Double totalWeight = 0.0;
        for (int i = 0; i < closestDistances.size(); i++) {
            if (closestDistances.get(i).getRSSI() == 0) {
                coorX = details.get(i).getCoor_x();
                coorY = details.get(i).getCoor_y();
                totalWeight = 1.0;
                break;
            }
            else {
                Double weight = 1/Math.sqrt(closestDistances.get(i).getRSSI());
                coorX+= weight * details.get(i).getCoor_x();
                coorY+= weight * details.get(i).getCoor_y();
                totalWeight+= weight;
            }
        }
        coorX = coorX / totalWeight;
        coorY = coorY / totalWeight;

        return new Coordinate(coorX, coorY);
    }

}
