package com.example.sample.controller;

import com.example.sample.model.Person;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class signup {

  @Autowired
  private UserService userService;

  @CrossOrigin(origins = "http://localhost:4200")
  @RequestMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {
    RequestMethod.POST})
  public boolean signUp(@RequestBody Person person) throws Exception {

    String signupError = null;

    String name = person.getUsername();
    String pwd = person.getPassword();
    System.out.println("name = " + name);

    if (!userService.isUsernameAvailable(person.getUsername())) {
      signupError = "The username already exists.";
    }

    if (signupError == null) {
      userService.createUser(person);
      return true;
    }
    return false;
  }
}
