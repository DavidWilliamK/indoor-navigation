package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.Coordinate;
import com.binus.indoornavigation.model.Position;
import com.binus.indoornavigation.model.enums.Binus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateTransformationImpl {

    public Position getTransformedPosition (Coordinate coordinate) {
        System.out.println(coordinate.getX() + ", " + coordinate.getY());
        int random = (int)(Math.random() * 5);
        return Binus.values()[random].getCampus();

    }
}
