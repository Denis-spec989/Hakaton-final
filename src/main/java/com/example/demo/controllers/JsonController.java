package com.example.demo.controllers;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.requests.PetrolStationRequest;
import com.example.demo.services.PetrolStationService;
import com.example.demo.services.convertors.impl.models.Csv;
import com.example.demo.services.convertors.impl.models.Json;
import com.example.demo.services.convertors.impl.models.JsonMultip;
import com.example.demo.services.impl.PetrolStationServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/json")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonController {

    private final PetrolStationService petrolStationService;

    @ApiOperation(
            value = "upload data via json"
    )
    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Object> createStationJson(@RequestBody ArrayList<PetrolStationRequest> petrolStationRequests) throws IOException {
        petrolStationService.load(
                new Json(petrolStationRequests)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @ApiOperation(
            value = "upload data via json multipart"
    )
    @PostMapping(value = "", consumes = "multipart/form-data")
    public ResponseEntity<Object> createStationJsonFile(@RequestParam("file") MultipartFile file) throws IOException {
        petrolStationService.load(
                new JsonMultip(file)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }
}
