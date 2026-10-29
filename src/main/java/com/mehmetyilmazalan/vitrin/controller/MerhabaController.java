package com.mehmetyilmazalan.vitrin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerhabaController {

    @GetMapping("/merhaba")
    public String merhaba() {
        return "Vitrin API çalışıyor";
    }

    @GetMapping("/uygulama")
    public String ilkMesaj(){
        return "Vitrin, bir e-ticaret uygulamasıdır.";
    }
}