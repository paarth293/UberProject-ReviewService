package com.example.uberreviewservices.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Booking extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})     //will generate a foreign key review_id
    //cascade type will automatically save review while saving booking
    //remove says if the booking is deleted all associated will be removed as well
    // in one to one one table has id of other table
    private Review review;
    //error was it was here must be a container so we created a list this msg is to just tell if there is some error asking for a container understand that they are asking that there must be a list not single
    //We made many to one bu then we reverted

    @Enumerated(value= EnumType.STRING)  //enum can be mapped either into integer or in form of string
    //always prefer string though integer is better when comes to terms of storage
    //enumerated tells that it is of enum
    private bookingStatus bookingStatus;


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startingTime;


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endingTime;


    private Long totalDistance;


    @ManyToOne      //spring is confused between one to many and many to many
    private Driver driver;    //if one side has one to many then other has many to one


    @ManyToOne
    private Passengers passenger;
}
