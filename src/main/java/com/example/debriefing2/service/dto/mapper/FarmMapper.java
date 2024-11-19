package com.example.debriefing2.service.dto.mapper;

import com.example.debriefing2.domain.Farm;
import com.example.debriefing2.domain.Field;
import com.example.debriefing2.service.dto.FarmDTO;
import com.example.debriefing2.service.dto.FieldDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface FarmMapper {
    FarmDTO toDto(Farm farm);
    Farm toEntity(FarmDTO farmDTO);
}