package me.jko.demospringdatajpa.shopping.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityExistsException;
import org.junit.jupiter.api.Test;

@DataJpaTest
@Rollback(value = false)
class CartRepositoryTest {

  @Autowired
  private CartRepository cartRepository;

  @Test
  void save() {
    Cart cart = new Cart();

    cartRepository.save(cart);
  }

  @Test
  void findById() {
    Cart cart = new Cart();
    cartRepository.save(cart);

    cartRepository.findById(1L).orElseThrow(EntityExistsException::new);
  }

  @Test
  void findByName() {
    Cart cart = new Cart("A cart");
    cartRepository.save(cart);

    cartRepository.findByName("A cart");
  }

  @Test
  void updateFirst() {
    Cart cart = new Cart("A cart");
    cartRepository.save(cart);
    cart.changeName("B Cart");
  }

  @Test
  void updateSecond() {
    Cart cart = new Cart("A cart");
    cartRepository.save(cart);

    cart.changeName("B Cart");
    cart.changeName("A cart");
  }

  @Test
  void delete() {
    Cart cart = new Cart("A cart");
    Cart savedCart = cartRepository.save(cart);

    cartRepository.delete(savedCart);
  }
}