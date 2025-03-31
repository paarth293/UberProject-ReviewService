package com.example.uberreviewservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing   //jpa will automatically handle auditing as an example created at and updated at
public class UberReviewServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberReviewServicesApplication.class, args);
    }

}
