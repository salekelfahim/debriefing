package com.example.debriefing2.web.rest;

import com.example.debriefing2.service.FarmService;
import com.example.debriefing2.service.dto.FarmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/farms")
public class FarmRest {

    @Autowired
    @Qualifier(value = "impl1" )
    private FarmService farmService;

    @PostMapping("/save")
    public ResponseEntity<FarmDTO> save(@RequestBody FarmDTO farmDTO) {
        FarmDTO savedFarmDTO = farmService.save(farmDTO);
        return ResponseEntity.ok(savedFarmDTO);
    }

    @GetMapping("/sum")
    public ResponseEntity<List<FarmDTO>> getFarmFArea4000() {
        List<FarmDTO> farms = farmService.getFarmFArea4000();
        return ResponseEntity.ok(farms);
    }

}
