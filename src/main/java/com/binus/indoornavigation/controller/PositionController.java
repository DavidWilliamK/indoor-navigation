package com.binus.indoornavigation.controller;

import com.binus.indoornavigation.model.Beacons;
import com.binus.indoornavigation.model.Signals;
import com.binus.indoornavigation.model.Coordinate;
import com.binus.indoornavigation.model.Position;
import com.binus.indoornavigation.service.PositionTransformationImpl;
import com.binus.indoornavigation.service.CoordinateTransformationImpl;
import com.binus.indoornavigation.web_model.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    PositionTransformationImpl positionTransformation;

    @Autowired
    CoordinateTransformationImpl coordinateTransformation;

    @GetMapping
    public ResponseEntity dummyApi(){

        List<Signals> signals = coordinateTransformation.getAllBeacons();

        return new ResponseEntity<>(
                new BaseResponse<>(
                        "OK", HttpStatus.OK.value(), signals
                ), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity getPositionFromCoordinates (
            @RequestBody List<Beacons> request
    ) {

        System.out.println("Init " + request);

        Coordinate coordinate = coordinateTransformation.getCoordinateFromBeacons(request);

        Position position = positionTransformation.getTransformedPosition(coordinate);

        return new ResponseEntity<>(
                new BaseResponse<>(
                        "OK", HttpStatus.OK.value(), position
                ), HttpStatus.OK
        );

    }
}
