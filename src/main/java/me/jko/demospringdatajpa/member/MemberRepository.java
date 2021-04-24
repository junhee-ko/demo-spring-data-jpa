package me.jko.demospringdatajpa.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

  List<Member> findByUsername(@Param("username") String username);
}
