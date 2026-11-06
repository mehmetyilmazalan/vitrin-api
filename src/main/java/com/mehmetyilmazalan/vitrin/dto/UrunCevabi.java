package com.mehmetyilmazalan.vitrin.dto;

import java.math.BigDecimal;

public class UrunCevabi {
    private int urunId;
    private String urunAdi;
    private BigDecimal urunFiyati;
    private boolean stoktaVarMi;


    public UrunCevabi(int urunId, String urunAdi, BigDecimal urunFiyati, boolean stoktaVarMi) {
        this.urunId = urunId;
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
        this.stoktaVarMi = stoktaVarMi;
    }

    public int getUrunId() {
        return urunId;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public BigDecimal getUrunFiyati() {
        return urunFiyati;
    }

    public boolean isStoktaVarMi() {
        return stoktaVarMi;
    }
}
