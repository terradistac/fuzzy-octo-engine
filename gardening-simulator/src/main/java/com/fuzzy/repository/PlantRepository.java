package com.fuzzy.repository;

import com.fuzzy.app.Plant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    
}