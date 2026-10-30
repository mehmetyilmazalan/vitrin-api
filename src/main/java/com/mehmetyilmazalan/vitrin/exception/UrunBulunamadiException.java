package com.mehmetyilmazalan.vitrin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UrunBulunamadiException extends RuntimeException {
  public UrunBulunamadiException(String message) {
    super(message);
  }
}
