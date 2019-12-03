package com.binus.indoornavigation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CoordinateController {

    @GetMapping("/api/coordinate")
    public String dummyApi(){
        return "Hi! Your backend is working fine";
    }
}
