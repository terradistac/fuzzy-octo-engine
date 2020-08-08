package com.fuzzy.app;

public enum PlantTypes {
    FLOWER("flower");

    private final String label;

    private PlantTypes(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    
}