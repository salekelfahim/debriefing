package com.example.debriefing2.service;

import com.example.debriefing2.service.dto.FarmDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FarmService {

    FarmDTO save(FarmDTO farmDTO);
    List<FarmDTO> getFarmFArea4000();

}
