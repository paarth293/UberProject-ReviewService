package com.example.uberreviewservices.repsitories;

import com.example.uberreviewservices.models.Driver;
import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverReposiory extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(long id, String licenseNumber);


    //let say we have to find a driver by its id and then we have to fetch all its bookings as well
    //for this we need a join

    List<Driver> findallByIdIn(List<Long> ids);

}
