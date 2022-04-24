package com.example.demo.services;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.models.PetrolStationModel;
import org.springframework.lang.Nullable;

import java.util.List;

public interface PetrolStationService {
    void save(PetrolStationDto patrolStationDto);

    void save(Iterable<PetrolStationDto> patrolStationDtos);

    <T> void load(T input);

    List<PetrolStationModel> get(
            @Nullable Integer limit,
            @Nullable Integer offset,
            @Nullable String address,
            @Nullable Double latitude,
            @Nullable Double longtitude,
            @Nullable String name,
            @Nullable String country,
            @Nullable String phone,
            @Nullable String region
            );
}
