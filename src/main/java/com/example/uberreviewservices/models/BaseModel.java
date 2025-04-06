package com.example.uberreviewservices.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass    //no table for the parent class and one table for each child having attributes of ts own and parent class
@Getter
@Setter

public abstract class BaseModel {

    @Id  //this annotation make id property makes id as primary key
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)    //format of create object
    @CreatedDate          //this annotation tells spring only to handle at creation
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate        //this annotation tells spring to handle when last modifies
    protected Date updatedAt;
}
