package com.mehmetyilmazalan.vitrin.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class UrunFiyatGuncellemeIstegi {
    @NotNull(message = "Yeni fiyat belirtilmelidir.")
    @Positive(message = "Fiyat 0 veya negatif olamaz.")
    private BigDecimal yeniFiyat;

    public BigDecimal getYeniFiyat(){
        return yeniFiyat;
    }

    public void setYeniFiyat(BigDecimal yeniFiyat){
        this.yeniFiyat=yeniFiyat;
    }


}
