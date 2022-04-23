package com.example.demo.repository;

import com.example.demo.entities.PetrolStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatrolStationRepository extends JpaRepository<PetrolStationEntity, UUID> {

}
