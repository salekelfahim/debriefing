package com.example.debriefing2.service.dto.mapper;

import com.example.debriefing2.domain.Field;
import com.example.debriefing2.service.dto.FieldDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    FieldDTO toDto(Field field);

    Field toEntity(FieldDTO fieldDTO);
}
