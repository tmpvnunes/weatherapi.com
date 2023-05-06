package com.codegate01.weatherapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Current {
    @Id
    private Long id;
    private Long last_updated_epoch;
    private String last_updated;
    private int temp_c;
    private double temp_f;
    private boolean is_day;
    private double wind_mph;
    private int wind_kph;
    private int wind_degree;
    private String wind_dir;
    private int pressure_mb;
    private double pressure_in;
    private int precip_mm;
    private int precip_in;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double feelslike_f;
    private int vis_km;
    private int vis_miles;
    private int uv;
    private double gust_mph;
    private double gust_kph;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "current_condition",
    joinColumns = @JoinColumn(name = "current_id"),
    inverseJoinColumns = @JoinColumn(name = "condition_id"))
    private List<Condition> condition = new ArrayList<>();


}
