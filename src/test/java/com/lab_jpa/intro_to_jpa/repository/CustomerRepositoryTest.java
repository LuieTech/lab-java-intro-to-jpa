package com.lab_jpa.intro_to_jpa.repository;

import com.lab_jpa.intro_to_jpa.model.Customer;
import com.lab_jpa.intro_to_jpa.model.CustomerStatus;
import com.lab_jpa.intro_to_jpa.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    Customer customer1;
    Customer customer2;

    CustomerStatus customerStatus;

    @BeforeEach
    void setUp() {


        customer1 = new Customer("luie", CustomerStatus.GOLD, 12000);
        customerRepository.save(customer1);
        customer2 = new Customer("mike", CustomerStatus.SILVER, 6000);
        customerRepository.save(customer2);

    }

    @AfterEach
    void tearDown() {

        customerRepository.deleteById(customer1.getCustomerId());
        customerRepository.deleteById(customer2.getCustomerId());
    }

    @Test
    public void FindCustomerById(){
        Optional<Customer> customerOptional = customerRepository.findById(customer1.getCustomerId());
        assertTrue(customerOptional.isPresent());
        System.out.println(customerOptional.get());
        assertEquals("luie", customerOptional.get().getCustomerName());
    }

    @Test
    public void findByName(){
        List<Customer> customerList = customerRepository.findAllByCustomerName(customer1.getCustomerName());
        assertFalse(customerList.isEmpty());
        System.out.println(customerList);
    }

    @Test
    public void findByStatus(){
        List<Customer> customerList = customerRepository.findAllByCustomerStatus(customer2.getCustomerStatus());
        assertFalse(customerList.isEmpty());
        System.out.println(customerList);
        assertEquals(4, customerList.size());

    }


}