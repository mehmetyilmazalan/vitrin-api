package com.mehmetyilmazalan.vitrin.controller;

import com.mehmetyilmazalan.vitrin.dto.StokDegisiklikIstegi;
import com.mehmetyilmazalan.vitrin.dto.UrunAdGuncellemeIstegi;
import com.mehmetyilmazalan.vitrin.dto.UrunFiyatGuncellemeIstegi;
import com.mehmetyilmazalan.vitrin.dto.UrunOlusturmaIstegi;
import com.mehmetyilmazalan.vitrin.model.Urun;
import com.mehmetyilmazalan.vitrin.repository.Repository;
import com.mehmetyilmazalan.vitrin.service.UrunServisi;
import jakarta.validation.Valid;
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
    public Urun katalogGoster(@PathVariable("urunId")Integer urunIdsi){
        return urunServisi.getir(urunIdsi);
    }

    @GetMapping("/katalog/ara")
    public List<Urun> urunAra(@RequestParam("ad") String urunAdi){

        return urunServisi.urunAra(urunAdi);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/katalog")
    public Urun urunBilgisiAl(@Valid @RequestBody UrunOlusturmaIstegi olusturulanUrun){
        return urunServisi.urunOlustur(olusturulanUrun);
    }

    @PatchMapping("/katalog/{urunId}/fiyat")
    public Urun fiyatGuncelle(@PathVariable("urunId") Integer urunIdsi,@Valid @RequestBody UrunFiyatGuncellemeIstegi urunFiyatGuncellemeIstegi){
        return urunServisi.fiyatGuncelle(urunIdsi,urunFiyatGuncellemeIstegi.getYeniFiyat());
    }

    @PatchMapping("/katalog/{urunId}/ad")
    public Urun urunAdiGuncelle(@PathVariable("urunId")Integer urunIdsi, @Valid @RequestBody UrunAdGuncellemeIstegi urunAdGuncellemeIstegi){
        return urunServisi.adGuncelle(urunIdsi, urunAdGuncellemeIstegi.getUrunAdi());
    }

    @PatchMapping("/katalog/{urunId}/stok/arttir")
    public Urun urunStokArttir(@PathVariable ("urunId")Integer urunIdsi, @Valid @RequestBody StokDegisiklikIstegi stokDegisiklikIstegi){
        return urunServisi.stokArttir(urunIdsi,stokDegisiklikIstegi.getMiktar());
    }

    @PatchMapping("/katalog/{urunId}/stok/azalt")
    public Urun urunStokAzalt(@PathVariable ("urunId")Integer urunIdsi, @Valid @RequestBody StokDegisiklikIstegi stokDegisiklikIstegi){
        return urunServisi.stokAzalt(urunIdsi,stokDegisiklikIstegi.getMiktar());
    }

    @GetMapping("/katalog/dusuk-stok")
    public List<Urun> dusukStokluUrunleriListele(@RequestParam("sinir") Integer stokSiniri){
        return urunServisi.dusukStokluUrunleriListele(stokSiniri);
    }





}