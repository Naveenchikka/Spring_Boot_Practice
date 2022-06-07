package com.example.sample.service;

import com.example.sample.model.Person;
import com.example.sample.repository.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

  @Autowired
  private SignUpRepo repo;


  public Person saveUser(Person person)
  {
    return repo.save(person);
  }

  public Person fetchUserByUserNameandPassword(String userName,String pwd)
  {
    return repo.findByUserName(userName,pwd);
  }

  public boolean isUsernameAvailable(String username)
  {
    return repo.findByUserName(username) == null;

  }

  public void createUser(Person person) {
//    SecureRandom random = new SecureRandom();
//    byte[] salt = new byte[16];
//    random.nextBytes(salt);
//    String encodedSalt = Base64.getEncoder().encodeToString(salt);
//    String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
//    return userMapper.insert(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName()));

      repo.saveAndFlush(person);
  }

}
