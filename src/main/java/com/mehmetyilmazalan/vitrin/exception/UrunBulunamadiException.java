package com.mehmetyilmazalan.vitrin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UrunBulunamadiException extends RuntimeException {
  public UrunBulunamadiException(String message) {
    super(message);
  }
}
