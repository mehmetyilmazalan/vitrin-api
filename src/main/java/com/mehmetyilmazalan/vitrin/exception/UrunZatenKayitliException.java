package com.mehmetyilmazalan.vitrin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UrunZatenKayitliException extends RuntimeException{
    public UrunZatenKayitliException(String message){
        super(message);
    }
}
