package com.example.sample.repository;

import com.example.sample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SignUpRepo extends JpaRepository<Person, Integer> {

  @Query("Select u from Person u where u.userName=:username and u.password=:password")
  Person findByUserName(@Param("username") String usn, @Param("password") String pwd);

  @Query("Select u from Person u where u.userName=:username")
  Person findByUserName(@Param("username") String usn);

//  @Modifying
//  @Query("insert into Person (name,password,firstname,lastname) select :userName,:pwd :fName :lName from Person")
//  int InsertPerson(@Param("userName")String usnName, @Param("pwd")String password, @Param("fName") String firstName, @Param("lName") String lastName);

//  @Transactional
//  public void insertPerson(Person person) {
//    this.entityManager.persist(person);
//  }
}

