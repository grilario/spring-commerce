package com.grilario.spring_commerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.grilario.spring_commerce.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
