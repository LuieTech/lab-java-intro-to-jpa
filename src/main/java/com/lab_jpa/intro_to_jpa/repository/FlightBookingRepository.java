package com.lab_jpa.intro_to_jpa.repository;

import com.lab_jpa.intro_to_jpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
