package com.mehmetyilmazalan.vitrin.controller;

import com.mehmetyilmazalan.vitrin.model.Urun;
import com.mehmetyilmazalan.vitrin.repository.Repository;
import com.mehmetyilmazalan.vitrin.service.UrunServisi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UrunController {

    private UrunServisi urunServisi;

    public UrunController(UrunServisi urunServisi) {
        this.urunServisi = urunServisi;
    }

    @GetMapping("/katalog")
    public List<Urun> katalogGoster(){

        return urunServisi.urunListele();

    }

    @GetMapping("/katalog/{urunId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Urun katalogGoster(@PathVariable("urunId")Integer urunIdsi){
        return urunServisi.getir(urunIdsi);
    }

    @GetMapping("/katalog/ara")
    public List<Urun> urunAra(@RequestParam("ad") String urunAdi){

        return urunServisi.urunAra(urunAdi);
    }

}