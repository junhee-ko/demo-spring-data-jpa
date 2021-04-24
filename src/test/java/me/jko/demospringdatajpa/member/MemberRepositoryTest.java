package me.jko.demospringdatajpa.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  void namedQuery() {
    new Member();
    Member minsu = new Member("minsu");
    memberRepository.save(minsu);

    List<Member> members = memberRepository.findByUsername("minsu");

    assertEquals(1, members.size());
    assertEquals("minsu", members.get(0).getUsername());
  }
}