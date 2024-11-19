package com.example.debriefing2.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FarmDTO {
    private Long id;
    private String name;
    private Double surface;
    private List<FieldDTO> fields;
}
