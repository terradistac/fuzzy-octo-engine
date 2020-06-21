package com.mycompany.module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GardeningModuleTest {

    private GardeningModule mockGardeningModule;

    @BeforeAll
    public void setup() {
        
    }

    @Test
    public void moduleLoadsProperMessages() {
        assertEquals("Welcome. Which plant would you like to grow?", mockGardeningModule.getGreeting());

    }
    
}