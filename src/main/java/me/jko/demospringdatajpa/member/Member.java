package me.jko.demospringdatajpa.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
    name = "Member.findByUsername",
    query = "select m from Member m where m.username = :username"
)
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  private String username;

  public Member() {
  }

  public Member(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}
