package com.grilario.spring_commerce.customer;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
