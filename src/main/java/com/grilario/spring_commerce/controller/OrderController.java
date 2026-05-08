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
import com.grilario.spring_commerce.model.Order;
import com.grilario.spring_commerce.model.Product;
import com.grilario.spring_commerce.repository.CustomerRepository;
import com.grilario.spring_commerce.repository.OrderRepository;
import com.grilario.spring_commerce.repository.ProductRepository;

@RestController()
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private ProductRepository productRepository;

  @GetMapping("")
  public Iterable<Order> list() {
    return orderRepository.findAll();
  }

  private record OrderCreate(Long customerID, Long productID, Integer quantity) {
  }

  @PostMapping("")
  public ResponseEntity<Order> create(@RequestBody OrderCreate data) {
    Customer customer = customerRepository
        .findById(data.customerID)
        .orElseThrow(() -> new ResourceNotFoundException());

    Product product = productRepository
        .findById(data.productID)
        .orElseThrow(() -> new ResourceNotFoundException());

    Order order = orderRepository.save(new Order(customer, product, data.quantity));

    return new ResponseEntity<Order>(order, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public Order get(@PathVariable Long id) {
    return orderRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException());

  }

  @DeleteMapping("/{id}")
  public Order delete(@PathVariable Long id) {
    Order order = orderRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException());

    orderRepository.delete(order);
    return order;
  }
}
