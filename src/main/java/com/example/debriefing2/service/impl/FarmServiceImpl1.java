package com.example.debriefing2.service.impl;

import com.example.debriefing2.domain.Farm;
import com.example.debriefing2.domain.Field;
import com.example.debriefing2.repository.FarmRepository;
import com.example.debriefing2.service.FarmService;
import com.example.debriefing2.service.dto.FarmDTO;
import com.example.debriefing2.service.dto.mapper.FarmMapper;
import com.example.debriefing2.web.errors.FarmFieldsNotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component(value = "impl1")
public class FarmServiceImpl1 implements FarmService {
    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private FarmMapper farmMapper;

    @Override
    public FarmDTO save(FarmDTO farmDTO) {
        if (farmDTO.getFields() != null && !farmDTO.getFields().isEmpty()) {
            throw new FarmFieldsNotAllowedException("Farm cannot have fields.");
        }

        Farm farm = farmMapper.toEntity(farmDTO);
        farm = farmRepository.save(farm);
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
