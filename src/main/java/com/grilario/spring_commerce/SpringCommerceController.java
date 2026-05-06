package com.grilario.spring_commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grilario.spring_commerce.customer.Customer;
import com.grilario.spring_commerce.customer.CustomerRepository;

@RestController
public class SpringCommerceController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/")
  public Iterable<Customer> get() {
    return customerRepository.findAll();
  }
}
