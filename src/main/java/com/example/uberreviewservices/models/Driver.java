package com.example.uberreviewservices.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false , unique=true)
    private String licenseNumber;

    // 1 to many association
    @OneToMany(mappedBy = "driver" , fetch = FetchType.LAZY)      //when we were not usng mapped by property extra table was creating
    private List<Booking> bookings = new ArrayList<>();

}
