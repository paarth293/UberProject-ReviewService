package com.example.uberreviewservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id  //this annotation make id property makes id as primary key
    Long id;
}
