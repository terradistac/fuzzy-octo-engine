package com.fuzzy.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class PlanterTest {
    
    private Planter testPlanter = new Planter();

    @Test
    public void testPlanterAddsNewPlantToCollection() {
        ArrayList<Plant> listOfPlants = new ArrayList<Plant>();
        Plant newPlantToAdd = new Plant();
        Plant newPlantToAdd2 = new Plant();

        testPlanter.addNewPlant(newPlantToAdd);
        testPlanter.addNewPlant(newPlantToAdd2);

        
        assertEquals(2, listOfPlants.size());
        
    }
    
}