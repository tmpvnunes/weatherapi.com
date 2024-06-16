package com.codegate01.weatherapi.repository;

import com.codegate01.weatherapi.model.WeatherResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherResponseRepository extends JpaRepository <WeatherResponse,Long> {
}
