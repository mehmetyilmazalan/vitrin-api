package com.mehmetyilmazalan.vitrin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UrunAdGuncellemeIstegi {

    @NotBlank(message = "Ürün adı null, boş veya yalnızca boşluklardan oluşamaz.")
    private String urunAdi;

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }
}
