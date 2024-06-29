package com.lab_jpa.intro_to_jpa.model;

import jakarta.persistence.*;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    // here the reference to customerId
    @ManyToOne
    private Customer customer;

    //here reference to flightId
    @ManyToOne
    private Flight flight;

    public FlightBooking() {
    }

    public FlightBooking(Integer bookingId, Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "bookingId=" + bookingId +
                ", customer=" + customer +
                ", flight=" + flight +
                '}';
    }
}
