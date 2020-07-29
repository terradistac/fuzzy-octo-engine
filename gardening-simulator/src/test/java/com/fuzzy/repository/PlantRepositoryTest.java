package com.fuzzy.repository;

import com.fuzzy.app.Plant;

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
    public void givenStudent_whenSave_thenGetOk() {
        Plant student = new Plant();
    }
}