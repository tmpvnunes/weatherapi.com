package com.codegate01.weatherapi.controller;

import com.codegate01.weatherapi.model.WeatherResponse;
import com.codegate01.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("api/v0/")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) throws IOException {
        return weatherService.getWeather(city);
    }
}
