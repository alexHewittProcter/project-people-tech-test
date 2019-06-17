package com.projectpeople.springboot2restservicebasic.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A extension of the JPA repository used for Customers
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
