package com.mehmetyilmazalan.vitrin.exception;


import com.mehmetyilmazalan.vitrin.dto.DogrulamaHataCevabi;
import com.mehmetyilmazalan.vitrin.dto.HataCevabi;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DogrulamaHataCevabi dogrulamaHatalariniYakala(MethodArgumentNotValidException hata){
        Map<String,String> alanHatalari = new HashMap<>();


        for(FieldError alanHatasi : hata.getBindingResult().getFieldErrors()){
            alanHatalari.put(alanHatasi.getField(),alanHatasi.getDefaultMessage());
        }

        DogrulamaHataCevabi dogrulamaHataCevabi=new DogrulamaHataCevabi("Gönderilen bilgiler geçersiz.",alanHatalari);
        return dogrulamaHataCevabi;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UrunBulunamadiException.class)
    public HataCevabi hataCevabi(UrunBulunamadiException hata){

        HataCevabi hataCevabi=new HataCevabi(hata.getMessage());
        return hataCevabi;

    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UrunZatenKayitliException.class)
    public HataCevabi hataCevabi(UrunZatenKayitliException hata){

        HataCevabi hataCevabi=new HataCevabi(hata.getMessage());
        return hataCevabi;

    }

}
