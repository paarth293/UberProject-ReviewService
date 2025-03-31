package com.example.uberreviewservices.services;

import com.example.uberreviewservices.models.Review;
import com.example.uberreviewservices.repsitories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******************");
        Review r = Review.builder()
                .content("Amazing Ride Quality")
                .creaedAt(new Date())
                .updatedAt(new Date())
                .rating(5.0)
                .build();
        System.out.println(r);
        reviewRepository.save(r);  // this code executes sql query

        List<Review> reviews = reviewRepository.findAll();

        for(Review revuew: reviews) {
            System.out.println(r.getContent());
        }
    }
}
