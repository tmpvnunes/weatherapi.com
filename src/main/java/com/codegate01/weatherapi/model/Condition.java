package com.codegate01.weatherapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity()
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String icon;
    private String code;

    @ManyToMany(mappedBy = "condition",fetch = FetchType.LAZY)
    private List<Current> currentList = new ArrayList<>();
}
