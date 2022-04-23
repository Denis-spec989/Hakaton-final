package com.example.demo.controllers;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.CsvService;
import com.example.demo.services.impl.PetrolStationServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvController {

    @Autowired
    private CsvService csvService;

    @PostMapping(value = "/newstation", consumes = "multipart/form-data")
    public ResponseEntity<Object> createStation (@RequestBody ArrayList<PetrolStationDto> petrolStationEntity) {
        csvService.save();
        return ResponseEntity.status(HttpStatus.CREATED).body("created csv");
    }
}
