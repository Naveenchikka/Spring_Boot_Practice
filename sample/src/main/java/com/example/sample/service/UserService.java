package com.example.sample.service;

import com.example.sample.dto.LogInResponseDTO;
import com.example.sample.dto.signInDTO;
import com.example.sample.dto.signUpDTO;
import com.example.sample.dto.ResponseDto;
import com.example.sample.exception.AuthenticationFailException;
import com.example.sample.exception.CustomException;
import com.example.sample.model.AuthenticationToken;
import com.example.sample.model.Person;
import com.example.sample.repository.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.SecondaryTable;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;

@Service
public class UserService {

  @Autowired
  private SignUpRepo repo;

  @Autowired
  AuthenticationService authenticationService;


  public Person fetchUserByUserNameandPassword(String email, String pwd) {
    return repo.findByUserName(email, pwd);
  }

  public boolean isUsernameAvailable(String email) {
    return repo.findByEmail(email) == null;
  }


  public LogInResponseDTO signIn(signInDTO signIndto) {
    Person user = repo.findByEmail(signIndto.getEmail());

    if (Objects.isNull(user)) {
      throw new AuthenticationFailException("user is not valid");
    }

    // hash the password

    try {
      if (!user.getPassword().equals(hashPassword(signIndto.getPassword()))) {
        throw new AuthenticationFailException("wrong password");
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    // compare the password in DB

    // if password match

    AuthenticationToken token = authenticationService.getToken(user);

    // retrive the token

    if (Objects.isNull(token)) {
      throw new CustomException("token is not present");
    }

    return new LogInResponseDTO("sucess", token.getToken());

    // return response
  }



  public ResponseDto createUser(signUpDTO signDTO) {

    if (Objects.nonNull(repo.findByEmail(signDTO.getEmail()))) {
      // we have an user
      throw new CustomException("user already present");
    }


    // hash the password

    String encryptedpassword = signDTO.getPassword();

    try {
      encryptedpassword = hashPassword(signDTO.getPassword());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    Person user = new Person(signDTO.getEmail(),encryptedpassword,signDTO.getFirstName(),signDTO.getLastName());

    repo.save(user);

    // save the user

    // create the token

    final AuthenticationToken authenticationToken = new AuthenticationToken(user);

    authenticationService.saveConfirmationToken(authenticationToken);

    ResponseDto responseDto = new ResponseDto("success", "user created succesfully");
    return responseDto;

  }

  private String hashPassword(String password) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(password.getBytes());
    byte[] digest = md.digest();
    String hash = DatatypeConverter
      .printHexBinary(digest).toUpperCase();
    return hash;
  }
}

