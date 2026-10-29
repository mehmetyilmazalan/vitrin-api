package com.mehmetyilmazalan.vitrin.repository;

import com.mehmetyilmazalan.vitrin.exception.UrunBulunamadiException;
import com.mehmetyilmazalan.vitrin.model.Urun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class UrunRepository implements Repository<Urun,Integer>{

    private final Map<Integer, Urun> urunKayitlari=new HashMap<>();

    @Override
    public void ekle(Urun urun){
        if(urunKayitlari.containsKey(urun.getUrunId())){
            throw new IllegalArgumentException("Bu id ile kayıtlı bir ürün zaten var.");
        }
        urunKayitlari.put(urun.getUrunId(),urun);
    }

    @Override
    public Urun getir(Integer urunId){
        if(!urunKayitlari.containsKey(urunId)){
            throw new UrunBulunamadiException("Bu ID ile kayıtlı bir ürün bulunamadı." + urunId);
        }
        return urunKayitlari.get(urunId);
    }

    @Override
    public List<Urun> listele(){
        ArrayList<Urun> urunListesi = new ArrayList<>(urunKayitlari.values());
        return urunListesi;
    }

    @Override
    public void guncelle(Urun urun){
        if(!urunKayitlari.containsKey(urun.getUrunId())){
            throw new IllegalArgumentException("Bu ID ye kayıtlı bir ürün bulunamadı.");
        }
        urunKayitlari.replace(urun.getUrunId(),urun);
    }

    @Override
    public boolean varMi(Integer urunId){
        if(urunKayitlari.containsKey(urunId)){
            return true;
        }
        return false;
    }
}
