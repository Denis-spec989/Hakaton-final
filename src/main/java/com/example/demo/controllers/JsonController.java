package com.example.demo.controllers;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.impl.PetrolStationServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/json")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonController {

    private final PetrolStationServiceImpl petrolStationService;

    @ApiOperation(
            value = "upload data via json"
    )
    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Object> createStationJson(@RequestBody ArrayList<PetrolStationDto> petrolStationEntity) {
        petrolStationService.save(petrolStationEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }
}
