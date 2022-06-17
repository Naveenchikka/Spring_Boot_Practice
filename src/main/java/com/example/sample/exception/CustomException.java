package com.example.sample.exception;

public class CustomException extends IllegalArgumentException {
  public CustomException(String msg) {
    super(msg);
  }

}
