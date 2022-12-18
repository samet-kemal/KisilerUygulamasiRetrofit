package com.example.kisileruygulamasi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisileruygulamasi.data.entity.CRUDCevap;
import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.data.entity.KisilerCevap;
import com.example.kisileruygulamasi.retrofit.KisilerDao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KisilerDaoRepository {//DAO : Database Access Object
    private MutableLiveData<List<Kisiler>> kisilerListesi;
    private KisilerDao kdao;

    public KisilerDaoRepository(KisilerDao kdao) {
        this.kdao=kdao;
        kisilerListesi = new MutableLiveData();
    }

    public MutableLiveData<List<Kisiler>> getKisilerListesi(){
        return kisilerListesi;
    }

    public void kisileriYukle(){
    kdao.kisileriYukle().enqueue(new Callback<KisilerCevap>() {
        @Override
        public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
            List<Kisiler> liste = response.body().getKisiler();
            kisilerListesi.setValue(liste);
        }

        @Override
        public void onFailure(Call<KisilerCevap> call, Throwable t) {

        }
    });

    }

    public void kaydet(String kisi_ad, String kisi_tel){
        kdao.kaydet(kisi_ad,kisi_tel).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {
            }
        });
    }

    public void guncelle(int kisi_id,String kisi_ad,String kisi_tel){
        kdao.guncelle(kisi_id,kisi_ad,kisi_tel).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {
            }
        });
    }

    public void ara(String aramaKelimesi){
        kdao.ara(aramaKelimesi).enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> liste = response.body().getKisiler();
                kisilerListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }

    public void sil(int kisi_id){
        kdao.sil(kisi_id).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                kisileriYukle();
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {
            }
        });    }
}
