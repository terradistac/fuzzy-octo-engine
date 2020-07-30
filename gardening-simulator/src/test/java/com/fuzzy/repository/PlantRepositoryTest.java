package com.fuzzy.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
  classes = { PlantJpaConfiguration.class }, 
  loader = AnnotationConfigContextLoader.class)
@Transactional
public class PlantRepositoryTest {
    
    @Autowired
    private PlantRepository plantRepository;
    
    @Test
    public void saveNewPlant_AndRetrieve() {
        Plant plant = new Plant();
        plant.setId(1);
        plantRepository.save(plant);
        Optional<Plant> retrievedPlant = plantRepository.findById(1l);
        assertNotNull(retrievedPlant.get());
    }
}