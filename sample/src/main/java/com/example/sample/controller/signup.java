package com.example.sample.controller;

import com.example.sample.dto.ResponseDto;
import com.example.sample.dto.signUpDTO;
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
  public ResponseDto signUp(@RequestBody signUpDTO signDTO) throws Exception {

    return userService.createUser(signDTO);
  }
}
