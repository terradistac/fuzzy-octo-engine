package com.fuzzy.plantManagement;

import com.fuzzy.repository.PlantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlantManagerImpl implements PlantManager{

    @Autowired
    public PlantRepository plantRepository;

    @Override
    public void addPlantToCollection(Plant plant) {
        plantRepository.save(new com.fuzzy.repository.Plant(plant));
    }

    @Override
    public void deletePlant(Plant plant) {
        plantRepository.deleteById(1l);
    }

    public void setPlantRepository(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }
    
}