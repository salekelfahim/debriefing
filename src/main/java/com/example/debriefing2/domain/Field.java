package com.example.debriefing2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double area;
    @ManyToOne
    private Farm farm;

    public Field(Long id, String name, Double area) {
        this.id = id;
        this.name = name;
        this.area = area;
    }

    public Field() {
    }
}
