package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.Coordinate;
import com.binus.indoornavigation.model.Position;
import org.springframework.stereotype.Service;

@Service
public class CoordinateTransformationImpl {

    public Position getTransformedPosition (Coordinate coordinate) {
        System.out.println(coordinate.getX() + ", " + coordinate.getY());
        return new Position(coordinate.getX() + 20, coordinate.getY() + 30);

    }
}
