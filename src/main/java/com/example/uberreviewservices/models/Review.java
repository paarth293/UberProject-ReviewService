package com.example.uberreviewservices.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name="bookingreview")    //to give custom name
//we have same property in enetity but does we choose to add another annotation rather than using entity only
//table annotation just changes name in database but entity works on java logic
public class Review {

    @Id  //this annotation make id property makes id as primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)            //after adding this property you need to drop tables first as it may show error but later on can be resolved by database migration
    String content;

    Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)    //format of create object
    @CreatedDate          //this annotation tells spring only to handle at creation
    Date creaedAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate        //thi annotation tells spring to handle when last modifies
    Date updatedAt;

}
