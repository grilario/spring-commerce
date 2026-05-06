package com.grilario.spring_commerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.grilario.spring_commerce.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
