package com.codegate01.weatherapi.controller;

import com.codegate01.weatherapi.entity.Location;
import com.codegate01.weatherapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("api/v0/")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("weather")
    public Location getLocation() throws IOException{
        return locationService.getLocation();
    }
}
