package me.jko.demospringdatajpa.shopping.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {

  @Id
  @GeneratedValue
  @Column(name = "CART_ID")
  private Long id;

  private String name;

  public Cart(String name) {
    this.name = name;
  }

  public Cart() {
  }

  public void changeName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
