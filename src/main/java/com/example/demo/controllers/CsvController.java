package com.example.demo.controllers;

import com.example.demo.convertors.CsvServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvController {

    @Autowired
    private CsvServiceImpl csvService;

    @GetMapping(value = "/test")
    public String test() {
        return "hello";
    }

    @PostMapping(value = "/newstation/csv", consumes = "multipart/form-data")
    public ResponseEntity<Object> createStationCsv (@RequestParam("file") MultipartFile file) throws IOException {
        csvService.save(file);
        return ResponseEntity.status(HttpStatus.CREATED).body("created csv");
    }
}

