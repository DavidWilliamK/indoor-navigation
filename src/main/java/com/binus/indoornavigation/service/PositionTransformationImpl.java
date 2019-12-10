package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.Coordinate;
import com.binus.indoornavigation.model.Position;
import com.binus.indoornavigation.model.enums.Binus;
import org.springframework.stereotype.Service;

@Service
public class PositionTransformationImpl {

    public Position getTransformedPosition (Coordinate coordinate) {

//        Operation to transform coordinate (X-axis, Y-axis) to position (Latitude, Longitude)
//        Note that this is still a dummy function which will return the position of a random Binus' campus
        System.out.println(coordinate.getX() + ", " + coordinate.getY());
        int random = (int)(Math.random() * 5);
        return Binus.values()[random].getCampus();

    }
}
