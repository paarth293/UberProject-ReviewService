package com.example.uberreviewservices.repsitories;

import com.example.uberreviewservices.models.Driver;
import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverReposiory extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(long id, String licenseNumber);


    //let say we have to find a driver by its id and then we have to fetch all its bookings as well
    //for this we need a join

    @Query(nativeQuery = true, value="SELECT * FROM Driver WHERE id = :id AND license_number = :license") //id native query is true it means raw query are allowed
    Optional<Driver> rawfindByIdandLAndLicenseNumber(Long id, String license);

    @Query("SELECT * FROM Driver where id = :id AND license_number = :adkl")
    Optional<Driver> rawfindByIdandLAndName(Long id, String name);
    //Hibernate error

    //raw query cant be detected at compile time so we need to check each query
    //but resolved in hibernate query

}
