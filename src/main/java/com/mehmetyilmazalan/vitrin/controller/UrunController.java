package com.mehmetyilmazalan.vitrin.controller;

import com.mehmetyilmazalan.vitrin.dto.*;
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
    public List<UrunCevabi> katalogGoster(){

        List<UrunCevabi> cevapListesi=new ArrayList<>();
        for(Urun urun:urunServisi.urunListele()){
            cevapListesi.add(urunCevabinaDonustur(urun));
        }
        return cevapListesi;
    }

    @GetMapping("/katalog/{urunId}")
        public UrunCevabi katalogGoster(@PathVariable("urunId")Integer urunIdsi){
        Urun urun=urunServisi.getir(urunIdsi);
        return urunCevabinaDonustur(urun);
    }

    @GetMapping("/katalog/ara")
    public List<UrunCevabi> urunAra(@RequestParam("ad") String urunAdi){

        List<UrunCevabi> aramaListesi=new ArrayList<>();
        for(Urun urun : urunServisi.urunAra(urunAdi)){
            aramaListesi.add(urunCevabinaDonustur(urun));
        }
        return aramaListesi;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/katalog")
    public UrunCevabi urunBilgisiAl(@Valid @RequestBody UrunOlusturmaIstegi olusturulanUrun){
        Urun urun = urunServisi.urunOlustur(olusturulanUrun);
        return urunCevabinaDonustur(urun);
    }

    @PatchMapping("/katalog/{urunId}/fiyat")
    public UrunCevabi fiyatGuncelle(
            @PathVariable("urunId") Integer urunIdsi,
            @Valid @RequestBody UrunFiyatGuncellemeIstegi istek
    ) {
        Urun urun = urunServisi.fiyatGuncelle(
                urunIdsi,
                istek.getYeniFiyat()
        );

        return urunCevabinaDonustur(urun);
    }

    @PatchMapping("/katalog/{urunId}/ad")
    public UrunCevabi urunAdiGuncelle(
            @PathVariable("urunId") Integer urunIdsi,
            @Valid @RequestBody UrunAdGuncellemeIstegi istek
    ) {
        Urun urun = urunServisi.adGuncelle(
                urunIdsi,
                istek.getUrunAdi()
        );

        return urunCevabinaDonustur(urun);
    }

    @PatchMapping("/katalog/{urunId}/stok/arttir")
    public UrunCevabi urunStokArttir(
            @PathVariable("urunId") Integer urunIdsi,
            @Valid @RequestBody StokDegisiklikIstegi istek
    ) {
        Urun urun = urunServisi.stokArttir(
                urunIdsi,
                istek.getMiktar()
        );

        return urunCevabinaDonustur(urun);
    }

    @PatchMapping("/katalog/{urunId}/stok/azalt")
    public UrunCevabi urunStokAzalt(
            @PathVariable("urunId") Integer urunIdsi,
            @Valid @RequestBody StokDegisiklikIstegi istek
    ) {
        Urun urun = urunServisi.stokAzalt(
                urunIdsi,
                istek.getMiktar()
        );

        return urunCevabinaDonustur(urun);
    }

    @GetMapping("/katalog/dusuk-stok")
    public List<UrunCevabi> dusukStokluUrunleriListele(@RequestParam("sinir") Integer stokSiniri){
         List<UrunCevabi>  dusukStokListesi=new ArrayList<>();
         for(Urun urun : urunServisi.dusukStokluUrunleriListele(stokSiniri)){
             dusukStokListesi.add(urunCevabinaDonustur(urun));
         }
         return dusukStokListesi;
    }
    @GetMapping("/katalog/fiyat-artan")
    public List<UrunCevabi> fiyataGoreArtanUrunListele(){

        List<UrunCevabi> fiyataGoreArtanListe = new ArrayList<>();
        for(Urun urun : urunServisi.fiyataGoreArtanListele()){
            fiyataGoreArtanListe.add(urunCevabinaDonustur(urun));
        }
        return fiyataGoreArtanListe;

    }


    @GetMapping("/katalog/fiyat-azalan")
    public List<UrunCevabi> fiyataGoreAzalanUrunListele(){

        List<UrunCevabi> fiyataGoreAzalanListe = new ArrayList<>();
        for(Urun urun : urunServisi.fiyataGoreAzalanListele()){
            fiyataGoreAzalanListe.add(urunCevabinaDonustur(urun));
        }
        return fiyataGoreAzalanListe;
    }

    @GetMapping("/katalog/ad-sirali")
    public List<UrunCevabi> adaGoreUrunListele(){

        List<UrunCevabi> adaGoreListe = new ArrayList<>();
        for(Urun urun : urunServisi.adaGoreListele()){
            adaGoreListe.add(urunCevabinaDonustur(urun));
        }
        return adaGoreListe;
    }


    public UrunCevabi urunCevabinaDonustur(Urun urun){
        UrunCevabi urunCevabi= new UrunCevabi(urun.getUrunId(),urun.getUrunAdi(),urun.getUrunFiyati(),urun.getUrunStok()>0);
        return urunCevabi;
    }







}