package com.lab_jpa.intro_to_jpa.repository;

import com.lab_jpa.intro_to_jpa.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    FlightRepository flightRepository;

    Flight flight1;

    @BeforeEach
    void setUp() {
        flight1 = new Flight("001", "Boeing", 60, 4000);
        flightRepository.save(flight1);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteById(flight1.getFlightId());
    }

    @Test
    public void findFlightTest(){
        Optional<Flight> flightOptional = flightRepository.findById(flight1.getFlightId());
        assertTrue(flightOptional.isPresent());
        System.out.println(flightOptional.get());
        assertEquals("001", flightOptional.get().getFlightNumber());
    }

    @Test
    public void findFlightByNumber(){
        Optional<Flight> flightOptional = flightRepository.findByFlightNumber(flight1.getFlightNumber());
        assertFalse(flightOptional.isEmpty());
        System.out.println(flightOptional);
        assertEquals(flight1.getFlightNumber(), flightOptional.get().getFlightNumber());
    }

    @Test
    public void findByAircraft(){
        List<Flight> flightList = flightRepository.findByAircraftContaining(flight1.getAircraft());
        assertFalse(flightList.isEmpty());
        System.out.println("this is the boeingList: "+ flightList);
        assertEquals(1, flightList.size());
    }

    @Test
    public void findAll_Flights_WithDistanceBiggerThan500Miles(){
        List<Flight> flightList = flightRepository.findAllByFlightMileageGreaterThan(flight1.getFlightMileage());
        assertTrue(flightList.isEmpty());
        System.out.println("bigger than 500miles: "+ flightList);
        assertEquals("001", flight1.getFlightNumber());
    }


}