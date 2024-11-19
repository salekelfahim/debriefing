package com.example.debriefing2.service.impl;

import com.example.debriefing2.domain.Farm;
import com.example.debriefing2.domain.Field;
import com.example.debriefing2.repository.FarmRepository;
import com.example.debriefing2.repository.FieldRepository;
import com.example.debriefing2.service.FarmService;
import com.example.debriefing2.service.dto.FarmDTO;
import com.example.debriefing2.service.dto.FieldDTO;
import com.example.debriefing2.service.dto.mapper.FarmMapper;
import com.example.debriefing2.web.errors.FieldsMustNotBeNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component(value = "impl2")
public class FarmServiceImpl2 implements FarmService {

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private FarmMapper farmMapper;

    @Autowired
    private FieldRepository fieldRepository;

    @Override
    public FarmDTO save(FarmDTO farmDTO) {
        if (farmDTO.getFields() == null || farmDTO.getFields().isEmpty()) {
            throw new FieldsMustNotBeNullException("Fields Must not be null.");
        }

        Farm farm = farmMapper.toEntity(farmDTO);

        farm = farmRepository.save(farm);

        for (FieldDTO fieldDTO : farmDTO.getFields()) {
            Field field = new Field();
            field.setFarm(farm);
            field.setName(fieldDTO.getName());
            field.setArea(fieldDTO.getSurface());

            fieldRepository.save(field);
        }

        farm = farmRepository.findById(farm.getId()).orElseThrow();

        return farmMapper.toDto(farm);
    }

    @Override
    public List<FarmDTO> getFarmFArea4000() {
        List<Farm> farms = farmRepository.findAll();

        farms.removeIf(farm -> farm.getFields().stream()
                .mapToDouble(Field::getArea)
                .sum() >= 4000);

        return farms.stream()
                .map(farmMapper::toDto)
                .collect(Collectors.toList());
    }

}
