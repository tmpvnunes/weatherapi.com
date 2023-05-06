package com.codegate01.weatherapi.entity;

import com.codegate01.weatherapi.model.Current;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "location")
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("region")
    @Column(name = "region")
    private String region;

    @JsonProperty("country")
    @Column(name = "country")
    private String country;

    @JsonProperty("lat")
    @Column(name = "latitude")
    private Double latitude;

    @JsonProperty("lon")
    @Column(name = "longitude")
    private Double longitude;

    @JsonProperty("tz_id")
    @Column(name = "tzone")
    private String tzone;

    @JsonProperty("localtime")
    @Column(name = "localTime")
    private String localTime;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="location_current",
    joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "current_id"))
    private List<Current> current;

    public Location(String name, String region, String country, Double latitude, Double longitude, String tzone, String localTime, List<Current> current) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tzone = tzone;
        this.localTime = localTime;
        this.current = current;
    }
}
