package com.fuzzy.plantManagement;

import com.fuzzy.repository.Plant;
import com.fuzzy.repository.PlantRepository;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlantManagerImplTest {

    public static PlantManagerImpl plantManagerImpl = new PlantManagerImpl();

    public static PlantRepository mockPlantRepository;

    @BeforeAll
    public static void setUp() {
        mockPlantRepository = EasyMock.createMock(PlantRepository.class);
        plantManagerImpl.setPlantRepository(mockPlantRepository);
    }

    @Test
    public void addPlant_CallsRepositoryOnce() {
        com.fuzzy.plantManagement.Plant plant = new com.fuzzy.plantManagement.Plant();

        EasyMock.expect(mockPlantRepository.save(EasyMock.anyObject(Plant.class))).andReturn(new Plant());
        EasyMock.replay(mockPlantRepository);

        plantManagerImpl.addPlantToCollection(plant);
        EasyMock.verify(mockPlantRepository);
    }
}