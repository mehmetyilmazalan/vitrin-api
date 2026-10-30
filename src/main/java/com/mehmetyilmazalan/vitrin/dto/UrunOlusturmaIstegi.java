package com.mehmetyilmazalan.vitrin.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class UrunOlusturmaIstegi {
    private int urunId;

    private String urunAdi;

    @NotNull(message = "Ürün fiyatı boş bırakılamaz.")
    @Positive(message = "Ürün fiyatı sıfırdan büyük olmalıdır.")
    private BigDecimal urunFiyati;

    private int urunStok;

    public String getUrunAdi(){
        return this.urunAdi;
    }
    public void setUrunAdi(String urunAdi){
        this.urunAdi=urunAdi;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public BigDecimal getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunFiyati(BigDecimal urunFiyati) {
        this.urunFiyati = urunFiyati;
    }

    public int getUrunStok() {
        return urunStok;
    }

    public void setUrunStok(int urunStok) {
        this.urunStok = urunStok;
    }
}
