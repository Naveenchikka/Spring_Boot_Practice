package com.example.sample.repository;

import com.example.sample.model.AuthenticationToken;
import com.example.sample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface tokenRepo extends JpaRepository<AuthenticationToken, Integer> {

  AuthenticationToken findByUser(Person user);
}
