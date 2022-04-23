package com.example.demo.controllers;

import com.example.demo.entities.PetrolStationEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonController {
    @PostMapping(value = "/newstation", consumes = "application/json")
    public ResponseEntity<Object> createPerson(@RequestBody PetrolStationEntity petrolStationEntity) {
//        personService.createPerson(newPerson);
//        String location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(newPerson.getId())
//                .toUriString();
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set(HttpHeaders.LOCATION, location);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }
}
