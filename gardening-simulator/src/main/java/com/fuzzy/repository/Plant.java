package com.fuzzy.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Plant {

    public Plant(){

    }

    public Plant (com.fuzzy.plantManagement.Plant plant) {
        
    }

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User userId;

    public void setId(long id) {
        this.id = id;
    }
    
}