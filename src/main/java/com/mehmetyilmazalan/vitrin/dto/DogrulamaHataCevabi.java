package com.mehmetyilmazalan.vitrin.dto;

import java.util.Map;


public class DogrulamaHataCevabi {
    private String mesaj;
    private Map<String,String> alanHatalari;


    public DogrulamaHataCevabi(String mesaj,Map<String,String> alanHatalari){
        this.mesaj=mesaj;
        this.alanHatalari=alanHatalari;
    }

    public String getMesaj(){
        return mesaj;
    }
    public Map<String,String> getAlanHatalari(){
        return alanHatalari;
    }

}
