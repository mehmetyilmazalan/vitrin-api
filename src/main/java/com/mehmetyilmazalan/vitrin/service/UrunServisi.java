package com.mehmetyilmazalan.vitrin.service;

import com.mehmetyilmazalan.vitrin.dto.UrunOlusturmaIstegi;
import com.mehmetyilmazalan.vitrin.model.Urun;
import com.mehmetyilmazalan.vitrin.repository.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Service
public class UrunServisi {

    private final Repository<Urun,Integer> urunRepository;

    public UrunServisi(Repository<Urun,Integer> urunRepository){
        this.urunRepository=urunRepository;
    }

    public void fiyatGuncelle(Integer urunId,BigDecimal yeniFiyat){
        urunRepository.getir(urunId).fiyatGuncelle(yeniFiyat);
    }
    public void adGuncelle(Integer urunId, String yeniAd) {
        urunRepository.getir(urunId).adGuncelle(yeniAd);
    }

    public void stokArttir(Integer urunId,Integer miktar){
        urunRepository.getir(urunId).stokArttir(miktar);
    }
    public void stokAzalt(Integer urunId, Integer miktar){
        urunRepository.getir(urunId).stokAzalt(miktar);
    }
    public void urunEkle(Urun urun){
        urunRepository.ekle(urun);
    }
    public List<Urun> urunListele(){
        return urunRepository.listele();
    }

    public List<Urun> urunAra(String arananAd) {
        if (arananAd == null || arananAd.isBlank()) {
            throw new IllegalArgumentException(
                    "Aranacak ürün adı boş olamaz."
            );
        }

        Locale turkce = Locale.forLanguageTag("tr");
        String aramaMetni = arananAd.strip().toLowerCase(turkce);

        List<Urun> bulunanUrunler = new ArrayList<>();

        for (Urun urun : urunRepository.listele()) {
            String urunAdi = urun.getUrunAdi().toLowerCase(turkce);

            if (urunAdi.contains(aramaMetni)) {
                bulunanUrunler.add(urun);
            }
        }

        return bulunanUrunler;
    }

    public List<Urun> fiyataGoreArtanListele() {
        List<Urun> urunler = urunRepository.listele();

        urunler.sort(Comparator.comparing(Urun::getUrunFiyati));

        return urunler;
    }

    public List<Urun> fiyataGoreAzalanListele() {
        List<Urun> urunler = urunRepository.listele();

        urunler.sort(
                Comparator.comparing(Urun::getUrunFiyati).reversed()
        );

        return urunler;
    }

    public List<Urun> adaGoreListele() {
        List<Urun> urunler = urunRepository.listele();

        Collator turkceSiralamasi =
                Collator.getInstance(Locale.forLanguageTag("tr"));

        urunler.sort(
                Comparator.comparing(
                        Urun::getUrunAdi,
                        turkceSiralamasi
                )
        );

        return urunler;
    }

    public List<Urun> dusukStokluUrunleriListele(int stokSiniri) {
        if (stokSiniri < 0) {
            throw new IllegalArgumentException(
                    "Stok sınırı negatif olamaz."
            );
        }

        List<Urun> dusukStokluUrunler = new ArrayList<>();

        for (Urun urun : urunRepository.listele()) {
            if (urun.getUrunStok() <= stokSiniri) {
                dusukStokluUrunler.add(urun);
            }
        }

        return dusukStokluUrunler;
    }

    public Urun getir(Integer urunId){
        return urunRepository.getir(urunId);
    }

    public Urun urunOlustur(UrunOlusturmaIstegi olusturulanUrun){
        Urun urun = new Urun(olusturulanUrun.getUrunId(),olusturulanUrun.getUrunAdi(),olusturulanUrun.getUrunFiyati(),olusturulanUrun.getUrunStok());
        urunRepository.ekle(urun);

        return urun;
    }

}
