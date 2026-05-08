package com.grilario.spring_commerce.controller;

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
import com.grilario.spring_commerce.model.Customer;
import com.grilario.spring_commerce.repository.CustomerRepository;

@RestController()
@RequestMapping("/customers")
public class CustomerController {
  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("")
  public Iterable<Customer> list() {
    return customerRepository.findAll();
  }

  record CustomerCreate(String name) {
  }

  @PostMapping("")
  public ResponseEntity<Customer> create(@RequestBody CustomerCreate data) {
    Customer customer = customerRepository.save(new Customer(data.name));

    return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public Customer get(@PathVariable Long id) {
    return customerRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException());
  }

  @DeleteMapping("/{id}")
  public Customer delete(@PathVariable Long id) {
    Customer customer = customerRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException());
    customerRepository.delete(customer);

    return customer;
  }
}
