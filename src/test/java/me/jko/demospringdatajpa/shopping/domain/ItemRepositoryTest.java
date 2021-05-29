package me.jko.demospringdatajpa.shopping.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;

@DataJpaTest
@Rollback(value = false)
class ItemRepositoryTest {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private CartRepository cartRepository;

  @Test
  void saveItem() {
    Item item = new Item();
    itemRepository.save(item);
  }

  @Test
  void saveItemWithCart() {
    Item item = new Item();
    Cart cart = new Cart("A cart");
    cartRepository.save(cart);

    item.setCart(cart);
    itemRepository.save(item);
  }

  @Test
  void findItemById() {
    Item item = itemRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
    Cart cart = item.getCart();
    cart.getName();
  }
}