package com.fuzzy.plantManagement;

import com.fuzzy.app.PlantTypes;

public class Plant {

    private PlantTypes plantType;
    private String userId;

    public void setPlantType(PlantTypes plantType) {
        this.plantType = plantType;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PlantTypes getPlantType() {
        return this.plantType;
    }

    public String getUserId() {
        return this.userId;
    }
    
}