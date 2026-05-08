package com.grilario.spring_commerce.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grilario.spring_commerce.errors.ResourceNotFoundException;
import com.grilario.spring_commerce.model.Product;
import com.grilario.spring_commerce.repository.ProductRepository;

@RestController()
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductRepository productRepository;

  @GetMapping("")
  public Iterable<Product> list() {
    return productRepository.findAll();
  }

  private record ProductCreate(String name, BigDecimal price, Boolean stock) {
  }

  @PostMapping("")
  public ResponseEntity<Product> create(@RequestBody ProductCreate data) {
    Product product = productRepository.save(new Product(data.name, data.price, data.stock));

    return new ResponseEntity<Product>(product, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public Product get(@PathVariable Long id) {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException());

  }

  @DeleteMapping("/{id}")
  public Product delete(@PathVariable Long id) {
    Product product = productRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException());

    productRepository.delete(product);
    return product;
  }
}
