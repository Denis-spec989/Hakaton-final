package com.example.demo.services;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.models.PetrolStationModel;

import java.util.List;

public interface PetrolStationService {
    void save(PetrolStationDto patrolStationDto);

    void save(Iterable<PetrolStationDto> patrolStationDtos);

    List<PetrolStationModel> get();
}
