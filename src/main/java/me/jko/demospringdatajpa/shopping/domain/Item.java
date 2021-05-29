package me.jko.demospringdatajpa.shopping.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

  @Id
  @GeneratedValue
  @Column(name = "item_id")
  private Long id;
  private String name;
  private Long price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CART_ID")
  private Cart cart;

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public Cart getCart() {
    return this.cart;
  }
}
