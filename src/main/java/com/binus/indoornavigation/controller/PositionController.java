package com.binus.indoornavigation.controller;

import com.binus.indoornavigation.model.Beacon;
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
    public String dummyApi(){
        return "Hi! Your backend is working fine, it is updated tho! Try it out using postman or etc.";
    }

    @PostMapping
    public ResponseEntity getPositionFromCoordinates (
            @RequestBody List<Beacon> request
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
