package com.example.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "NEW_TABLE")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="USER_ID")
  private Integer userId;

  @Column(name="USER_MAIL")
  private String email;

  @Column(name="PASSWORD")
  private String password;

  @Column(name="FIRSTNAME")
  private String firstName;

  @Column(name="LASTNAME")
  private String lastName;

//  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "AuthenticationToken")
//  private Person user;

  public Person()
  {

  }

  public Person(String email, String password, String firstName, String lastName) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "User [id=" + userId + ", user_email=" + email + ", user_fname=" + firstName + ", user_lname=" + lastName + ", user_pass=" + password+"]";
  }

}
