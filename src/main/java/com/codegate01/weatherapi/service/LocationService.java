package com.codegate01.weatherapi.service;

import com.codegate01.weatherapi.entity.Location;
import com.codegate01.weatherapi.rapidapi.WeatherApiPayload;
import com.codegate01.weatherapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LocationService {

    @Autowired
    private Environment environment;
    @Autowired
    private LocationRepository locationRepository;

    public Location getLocation() throws IOException {
        String apiKey = environment.getProperty("X-RapidAPI-Key");
        String apiHost = environment.getProperty("X-RapidAPI-Host");
        String realtimeWeather = environment.getProperty("RealtimeWeather");


        WeatherApiPayload payload = new WeatherApiPayload();
        Location locations = payload.getLocationData(realtimeWeather,apiKey,apiHost);
        locationRepository.save(locations);

        return locations;

    }
}
