package com.example.demo.repository;

import com.example.demo.model.PetrolStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatrolStationRepository  extends JpaRepository<PetrolStation,Long> {
}
