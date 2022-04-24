package com.example.demo.controllers;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.models.PetrolStationModel;
import com.example.demo.responses.PetrolStationResponse;
import com.example.demo.services.PetrolStationService;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PetrolController {
    private final PetrolStationService petrolStationService;

    @GetMapping("")
    @ApiOperation(value = "Get saved petrol stations")
    public List<PetrolStationResponse> get(
        @RequestParam(value = "limit", required = false) Integer limit,
        @RequestParam(value = "offset", required = false) Integer offset,
        @RequestParam(value = "address", required = false) String address,
        @RequestParam(value = "latitude", required = false) Double latitude,
        @RequestParam(value = "longtitude", required = false) Double longtitude,
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "country", required = false) String country,
        @RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "region", required = false) String region
    ) {
        if (limit != null && offset != null) {
            if (limit < 1 || offset < 0 || limit > 10)
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "incorrect limit or offset");
        }

        List<PetrolStationModel> petrolStationDtos = petrolStationService.get(
                limit,
                offset,
                address,
                latitude,
                longtitude,
                name,
                country,
                phone,
                region
        );
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
