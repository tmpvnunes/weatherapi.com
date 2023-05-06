package com.codegate01.weatherapi.repository;

import com.codegate01.weatherapi.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository <Location,Long> {
}
