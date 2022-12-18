package com.example.kisileruygulamasi.di;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;
import com.example.kisileruygulamasi.retrofit.ApiUtils;
import com.example.kisileruygulamasi.retrofit.KisilerDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(KisilerDao kisilerDao){
        return new KisilerDaoRepository(kisilerDao);


    }
    @Provides
    @Singleton
    public KisilerDao provideKisilerDao(){
        return ApiUtils.getKisilerDao();
    }
}
