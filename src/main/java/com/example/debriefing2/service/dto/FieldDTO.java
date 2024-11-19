package com.example.debriefing2.service.dto;

import com.example.debriefing2.domain.Farm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldDTO {
    private Long id;
    private String name;
    private Double surface;
    private Farm farm;

}
