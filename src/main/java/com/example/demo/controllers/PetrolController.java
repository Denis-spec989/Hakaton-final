package com.example.demo.controllers;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.models.PetrolStationModel;
import com.example.demo.responses.PetrolStationResponse;
import com.example.demo.services.PetrolStationService;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PetrolController {
    private final PetrolStationService petrolStationService;

    @GetMapping("")
    @ApiOperation(value = "Get saved petrol stations")
    public List<PetrolStationResponse> get() {
        List<PetrolStationModel> petrolStationDtos = petrolStationService.get();
        List<PetrolStationResponse> petrolStationResponses = new ArrayList<>();

        for (PetrolStationModel model : petrolStationDtos) {
            petrolStationResponses.add(
                    new PetrolStationResponse(
                            model.getId().toString(),
                            model.getAddress(),
                            model.getLatitude(),
                            model.getLongtitude(),
                            model.getName(),
                            model.getCountry(),
                            model.getPhone(),
                            model.getRegion()
                    )
            );
        }

        return petrolStationResponses;
    }
}
