package com.example.demo.controllers;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.impl.PetrolStationServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XMLController {
    @Autowired
    PetrolStationServiceImpl petrolStationService;

    @PostMapping(value = "/newstation", consumes = "multipart/form-data")
    public ResponseEntity<Object> createStations (@RequestParam("file") MultipartFile file) {

        return ResponseEntity.status(HttpStatus.CREATED).body("created csv");
    }
}
