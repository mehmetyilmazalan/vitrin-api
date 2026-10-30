package com.mehmetyilmazalan.vitrin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class UrunOlusturmaIstegi {

    @Positive(message = "Ürün ID negatif veya sıfır olamaz.")
    private int urunId;

    @NotBlank(message = "Ürün adı boş bırakılamaz.")
    private String urunAdi;

    @NotNull(message = "Ürün fiyatı boş bırakılamaz.")
    @Positive(message = "Ürün fiyatı sıfırdan büyük olmalıdır.")
    private BigDecimal urunFiyati;

    @PositiveOrZero(message = "Ürün stok sayısı negatif olamaz.")
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
