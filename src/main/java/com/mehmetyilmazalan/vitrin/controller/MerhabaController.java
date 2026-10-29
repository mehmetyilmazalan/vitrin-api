package com.mehmetyilmazalan.vitrin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/odalar/{odaNo}")
        public String odaBul(@PathVariable("odaNo") Integer numara){
        return numara + " numaralı oda seçildi.";
    }

    @GetMapping("/otel")
    public String manzaraSec(@RequestParam("sehir") String arananSehir){

        return "Aranan Şehir :" + arananSehir;
    }

}