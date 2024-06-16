package com.codegate01.weatherapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity()
@Table(name = "`CONDITION`") // Enclose reserved word in backticks
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String icon;
    private int code;

    @OneToOne(mappedBy = "condition", cascade = CascadeType.ALL)
    private Current current;

}
