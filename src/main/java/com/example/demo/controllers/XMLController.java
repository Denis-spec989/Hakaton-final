package com.example.demo.controllers;

import com.example.demo.services.PetrolStationService;
import com.example.demo.services.convertors.impl.models.PXML;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transaction;
import java.io.IOException;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("/api/v1/xml")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XMLController {

    private final PetrolStationService petrolStationService;

    @ApiOperation(
            value = "Upload data using xml format"
    )
    @PostMapping(value = "", consumes = "multipart/form-data")
    public ResponseEntity<Object> createStations(@RequestParam("file") MultipartFile file) throws IOException {
        petrolStationService.load(
                new PXML(file)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }



}
