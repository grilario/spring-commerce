package com.grilario.spring_commerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.grilario.spring_commerce.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
