package com.grilario.spring_commerce.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer {
  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Getter
  @Setter
  @NonNull
  private String name;

  @Getter
  @CreationTimestamp
  private LocalDate since;
}
