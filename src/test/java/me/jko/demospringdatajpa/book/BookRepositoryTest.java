package me.jko.demospringdatajpa.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepository;

  @Test
  void create() {
    Book book = new Book("Java");
    bookRepository.save(book);
  }

  @Test
  @Transactional
  @Rollback(value = false)
  void read() {
    Book book = new Book("Java");
    Book savedBook = bookRepository.save(book);
    Book selectedBook = bookRepository.findById(savedBook.getId()).orElseThrow(EntityNotFoundException::new);

    assertNotNull(selectedBook);
  }

  @Test
  void update() {
    Book book = new Book("Java");
    Book savedBook = bookRepository.save(book);
    savedBook.setName("JPA");
    bookRepository.save(book);
  }

  @Test
  void delete() {
    Book book = new Book("Java");
    Book savedBook = bookRepository.save(book);

    bookRepository.delete(savedBook);
  }

  @Test
  @Transactional
  void queryMethod() {
    Book selectedBook = bookRepository.findByName("Java");

    assertNull(selectedBook);
  }
}