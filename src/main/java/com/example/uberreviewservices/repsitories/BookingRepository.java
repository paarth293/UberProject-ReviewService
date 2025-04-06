package com.example.uberreviewservices.repsitories;

import com.example.uberreviewservices.models.Booking;
import com.example.uberreviewservices.models.Driver;
import com.example.uberreviewservices.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {



}
