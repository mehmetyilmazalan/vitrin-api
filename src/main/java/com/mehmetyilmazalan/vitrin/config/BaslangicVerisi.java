package com.mehmetyilmazalan.vitrin.config;



import com.mehmetyilmazalan.vitrin.model.Urun;
import com.mehmetyilmazalan.vitrin.service.UrunServisi;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;



import java.math.BigDecimal;

@Component
public class BaslangicVerisi implements CommandLineRunner {
    private UrunServisi urunServisi;

    public BaslangicVerisi(UrunServisi urunServisi){
        this.urunServisi=urunServisi;
    }


    @Override
    public void run(String... args) {

        Urun urun1 = new Urun(1,"Klavye",new BigDecimal(100),10);
        Urun urun2 = new Urun(2,"Mouse",new BigDecimal(50),5);

        urunServisi.urunEkle(urun1);
        urunServisi.urunEkle(urun2);

    }


}
