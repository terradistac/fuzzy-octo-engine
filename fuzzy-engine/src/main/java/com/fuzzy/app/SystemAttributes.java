package com.fuzzy.app;

public enum SystemAttributes {
    LANGUAGE("language");

    private final String label;

    SystemAttributes(String label) { 
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}