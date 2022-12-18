package com.example.kisileruygulamasi.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Kisiler implements Serializable {
    @SerializedName("kisi_id")
    private int kisi_id;
    @SerializedName("kisi_ad")
    private String kisi_ad;
    @SerializedName("kisi_tel")
    private String kisi_tel;

    public Kisiler() {
    }

    public Kisiler(int kisi_id, String kisi_ad, String kisi_tel) {
        this.kisi_id = kisi_id;
        this.kisi_ad = kisi_ad;
        this.kisi_tel = kisi_tel;
    }

    public int getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(int kisi_id) {
        this.kisi_id = kisi_id;
    }

    public String getKisi_ad() {
        return kisi_ad;
    }

    public void setKisi_ad(String kisi_ad) {
        this.kisi_ad = kisi_ad;
    }

    public String getKisi_tel() {
        return kisi_tel;
    }

    public void setKisi_tel(String kisi_tel) {
        this.kisi_tel = kisi_tel;
    }
}
