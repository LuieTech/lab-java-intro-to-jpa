package com.lab_jpa.intro_to_jpa.repository;

import com.lab_jpa.intro_to_jpa.model.Customer;
import com.lab_jpa.intro_to_jpa.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //JPA Keyword
    List<Customer> findAllByCustomerName(String customerName);
    List<Customer> findAllByCustomerStatus(CustomerStatus customerStatus);

}
