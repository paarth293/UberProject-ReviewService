package com.example.uberreviewservices.repsitories;

import com.example.uberreviewservices.models.Driver;
import com.example.uberreviewservices.models.Passengers;
import com.example.uberreviewservices.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("SELECT r from Booking b inner join Review r where b.id = :bookingId")
    Review findReviewByBookingId(long bookingId);

    @Query("select new com.example.uberreviewservices.repsitories(r, p, d) from Booking b inner join Passengers p inner join Driver d")
    custom findDriverPassengerReviewByBookingId(Long bookingId);
}

class custom {
    public Review review;
    public Passengers passenger;
    public Driver driver;

    public custom(Review review, Passengers passenger, Driver driver) {
        this.driver = driver;
        this.review = review;
        this.passenger = passenger;
    }
}