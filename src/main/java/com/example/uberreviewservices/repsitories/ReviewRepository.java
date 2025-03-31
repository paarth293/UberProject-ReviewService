package com.example.uberreviewservices.repsitories;

import com.example.uberreviewservices.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


}
