package com.example.uberreviewservices.repsitories;

import com.example.uberreviewservices.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository implements CommandLineRunner {  //we want to load something after loading the project
    @Override
    public void run(String... args) throws Exception {
        System.out.println("*********************");
        Review r = Review
                .builder()
                .content("Amazing ride quality")
                .rating(5.0)
                .build();     //creating new object of class review
                              //no sql query executed as it is just a java code and there is no communication with the database
                              //in order to do so either use raw queries or hibernate queries or we can use r.save that is yet to be exposed to us
    }
}
