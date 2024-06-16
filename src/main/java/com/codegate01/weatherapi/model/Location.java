package com.codegate01.weatherapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String region;
    private String country;

    private double lat;
    private double lon;

    private String tz_id;
    private long localtime_epoch;

    @Column(name = "`localtime`") // Enclose reserved word in backticks
    private String localtime;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<WeatherResponse> weatherResponses;

}
