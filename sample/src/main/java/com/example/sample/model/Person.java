package com.example.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="USER_ID")
  private Integer userId;
  @Column(name="USER_NAME")
  private String userName;
  @Column(name="PASSWORD")
  private String password;
  @Column(name="FIRST_NAME")
  private String firstName;
  @Column(name="LAST_NAME")
  private String lastName;

  public Person()
  {

  }

  public Person(String username, String password, String firstName, String lastName) {
    this.userId = userId;
    this.userName = username;
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

  public String getUsername() {
    return userName;
  }

  public void setUsername(String username) {
    this.userName = username;
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
    return "User [id=" + userId + ", user_name=" + userName + ", user_fname=" + firstName + ", user_lname=" + lastName + ", user_pass=" + password+"]";
  }

}
