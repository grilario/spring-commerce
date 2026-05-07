package com.grilario.spring_commerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer_order")
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {
  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Getter
  @Setter
  @NonNull
  @ManyToOne
  @JoinColumn
  private Customer customer;

  @Getter
  @Setter
  @NonNull
  @ManyToOne
  @JoinColumn
  private Product product;

  @Getter
  @Setter
  @NonNull
  private Integer quantity;
}
