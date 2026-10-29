package com.mehmetyilmazalan.vitrin.controller;

import com.mehmetyilmazalan.vitrin.model.Urun;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UrunController {

    @GetMapping("/katalog")
    public List<Urun> katalogGoster(){

        Urun urun1= new Urun(1,"Klavye",BigDecimal.valueOf(100),10);
        Urun urun2= new Urun(2,"Mouse",BigDecimal.valueOf(50),5);

        ArrayList<Urun> urunListesi=new ArrayList<>();
        urunListesi.add(urun1);
        urunListesi.add(urun2);
        return urunListesi;


    }
}