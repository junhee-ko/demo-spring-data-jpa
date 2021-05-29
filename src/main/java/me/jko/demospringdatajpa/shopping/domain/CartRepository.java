package me.jko.demospringdatajpa.shopping.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

  Cart findByName(String name);
}
