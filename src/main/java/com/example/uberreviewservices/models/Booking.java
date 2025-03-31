package com.example.uberreviewservices.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

    @Enumerated(value= EnumType.STRING)  //enum can be mapped either into integer or in form of string
    //always prefer string though integer is better when comes to terms of storage
    //enumerated tells that it is of enum
    private bookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startingTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endingTime;

    private Long totalDistance;
}
