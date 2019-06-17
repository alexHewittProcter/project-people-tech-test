package com.projectpeople.springboot2restservicebasic.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;

    /**
     * Used to show all customers stored
     * Using the url /customers
     * @return list of customers
     */
    @GetMapping("/customers")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    /**
     * Gets a specific customer based on the id provided
     * Accessed using /customers/id
     * @param id
     * @return a customer object
     */
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    /**
     * Deletes a specific customer from the database using a specific id
     * Uses a DELETE request at the url /customers/id
     * @param id
     */
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    /**
     * Adds a customer to the database store using a POST request
     * At the /customers url
     * @param customer
     * @return the created customer object
     */
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    /**
     * Updates a customer based on a specific id
     * Uses a PUT request with the url /customers/id
     * @param customer
     * @param id
     * @return the updated customer
     */
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()) {
            customer.id = id;
            customerRepository.save(customer);
            return customer;
        } else {
            return null;
        }
    }

}
