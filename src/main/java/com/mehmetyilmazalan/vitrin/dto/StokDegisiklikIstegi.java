package com.mehmetyilmazalan.vitrin.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StokDegisiklikIstegi {

    @NotNull(message = "Miktar belirtilmelidir.")
    @Positive(message = "Miktar sıfırdan büyük olmalıdır.")
    private Integer miktar;

    public Integer getMiktar() {

        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }
}
