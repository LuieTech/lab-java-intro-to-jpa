package com.lab_jpa.intro_to_jpa.repository;


import com.lab_jpa.intro_to_jpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraft);
    List<Flight> findAllByFlightMileageGreaterThan(Integer flightMileage);
}
