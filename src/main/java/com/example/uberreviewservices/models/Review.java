package com.example.uberreviewservices.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bookingreview")    //to give custom name
//we have same property in entity but does we choose to add another annotation rather than using entity only
//table annotation just changes name in database but entity works on java logic
public class Review extends BaseModel {

    @Column(nullable = false)            //after adding this property you need to drop tables first as it may show error but later on can be resolved by database migration
    private String content;

    private Double rating;

    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt;
    }

}
