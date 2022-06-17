package com.example.sample.service;

import com.example.sample.model.AuthenticationToken;
import com.example.sample.model.Person;
import com.example.sample.repository.tokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  @Autowired
  tokenRepo tokenRepository;

  public void saveConfirmationToken(AuthenticationToken authenticationToken) {
    tokenRepository.save(authenticationToken);
  }

  public AuthenticationToken getToken(Person user) {
    return tokenRepository.findByUser(user);
  }
}
