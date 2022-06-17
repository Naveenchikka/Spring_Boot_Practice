package com.example.sample.controller;

import com.example.sample.dto.LogInResponseDTO;
import com.example.sample.dto.signInDTO;
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
  public LogInResponseDTO loginValid(@RequestBody signInDTO signIndto) throws Exception {

    return userService.signIn(signIndto);

  }
}
