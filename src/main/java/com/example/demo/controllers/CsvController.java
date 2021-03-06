package com.example.demo.controllers;

import com.example.demo.services.PetrolStationService;
import com.example.demo.services.convertors.impl.models.Csv;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/csv")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvController {

    private final PetrolStationService petrolStationService;

    @ApiOperation(
            value = "upload data via csv format"
    )
    @PostMapping(value = "", consumes = "multipart/form-data")
    public ResponseEntity<Object> createStationCsv(@RequestParam("file") MultipartFile file) throws IOException {
        petrolStationService.load(
                new Csv(file)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }
}

