package com.example.uberreviewservices.services;

import com.example.uberreviewservices.models.Booking;
import com.example.uberreviewservices.models.Driver;
import com.example.uberreviewservices.models.Review;
import com.example.uberreviewservices.repsitories.BookingRepository;
import com.example.uberreviewservices.repsitories.DriverReposiory;
import com.example.uberreviewservices.repsitories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private final DriverReposiory driverReposiory;
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverReposiory driverReposiory) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverReposiory = driverReposiory;
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

//        System.out.println(r);
//        //reviewRepository.save(r);  // this code executes sql query
//        System.out.println(r.getId());
//
//        List<Review> reviews = reviewRepository.findAll();
//
//        for(Review review: reviews) {
//            System.out.println(r.getContent());
//        }

//        Optional<Driver> driver = driverReposiory.findByIdAndLicenseNumber(1L , "DL21212");
//        if(driver.isPresent()) {
//            System.out.println(driver.get().getName());
//            List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//            for(Booking booking: bookings) {
//                System.out.println(booking.getBookingStatus());
//            }
//        }

//        Optional<Driver> driver = driverReposiory.findById(1L);
//        if(driver.isPresent()) {
//            System.out.println(driver.get().getName());    //if we are fetching driver details it is also fetching booking details and all other associated with driver for his we need fetch types eager and lazy
//        }
        //if we fetch only driver details and later on we want to fetch booking details we can fetch by creating an object and storing in a list and hence printing it

        List<Long> driver_ids = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        List<Driver> drivers = driverReposiory.findallByIdIn(driver_ids);

        //List<Booking> bookings = driverRepository.findallByIdIn(drivers);

        for (Driver driver : drivers) {
            System.out.println(driver.getBookings().size());
            final Set<Booking> bookings = driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }
    }
}
