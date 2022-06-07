package com.example.sample.controller;

import com.example.sample.model.Person;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class login {

  @Autowired
  private UserService userService;


  @CrossOrigin(origins = "http://localhost:4200")
  @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,method = {
    RequestMethod.POST})
  public boolean loginValid(@RequestBody Person person) throws Exception {

    String name = person.getUsername();
    String pwd = person.getPassword();
    System.out.println("name = "+name);

    Person userName = userService.fetchUserByUserNameandPassword(name,pwd);
    System.out.println("loginUse "+userName);

    String loginError = null;

    if ((userName != null) &&  (!(userService.isUsernameAvailable(person.getUsername()))))
    {
      loginError = "The username exists.";
      return true;
    }
    else
    {
      return false;
    }

  }
}
