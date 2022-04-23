package com.example.demo.services.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.entities.PetrolStationEntity;
import com.example.demo.models.PetrolStationModel;
import com.example.demo.repository.PetrolStationRepository;
import com.example.demo.services.PetrolStationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PetrolStationServiceImpl implements PetrolStationService {
    private final PetrolStationRepository patrolStationRepository;

    PetrolStationEntity dtoToEntity(PetrolStationDto petrolStationDto) {
        return new PetrolStationEntity(
                petrolStationDto.getAddress(),
                petrolStationDto.getLatitude(),
                petrolStationDto.getLongtitude(),
                petrolStationDto.getName(),
                petrolStationDto.getCountry(),
                petrolStationDto.getPhone(),
                petrolStationDto.getRegion()
        );
    }

    @Override
    public void save(PetrolStationDto petrolStationDto) {
        patrolStationRepository.save(
                dtoToEntity(petrolStationDto)
        );
    }

    @Override
    public void save(Iterable<PetrolStationDto> petrolStationDtos) {
        ArrayList<PetrolStationEntity> petrolStationEntities = new ArrayList<>();
        for (PetrolStationDto dto : petrolStationDtos) {
            petrolStationEntities.add(
                    dtoToEntity(dto)
            );
        }

        patrolStationRepository.saveAll(petrolStationEntities);
    }

    @Override
    public List<PetrolStationModel> get() {
        return null;
    }


}
