package com.example.uberreviewservices.services;

import com.example.uberreviewservices.models.Booking;
import com.example.uberreviewservices.models.Review;
import com.example.uberreviewservices.repsitories.BookingRepository;
import com.example.uberreviewservices.repsitories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******************");
        Review r = Review.builder()
                .content("Amazing Ride Quality")
                .rating(5.0)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        Booking b = Booking
                .builder()
                .review(r)       //we are establishing relationship between two objects
                .endingTime(new Date())
                .build();         //in order to save  we need to make a booking repository

        //reviewRepository.save(r);     //we have to save review before booking as booking is dependent on review    we have to manage this on our own    for this we have cascade property
        bookingRepository.save(b);

        System.out.println(r);
        //reviewRepository.save(r);  // this code executes sql query
        System.out.println(r.getId());

        List<Review> reviews = reviewRepository.findAll();

        for(Review review: reviews) {
            System.out.println(r.getContent());
        }
    }
}
