package com.example.kisileruygulamasi.retrofit;

public class ApiUtils {
   public static final String BASE_URL="http://kasimadalan.pe.hu/";

   public static KisilerDao getKisilerDao(){
      return RetrofitClient.getClient(BASE_URL).create(KisilerDao.class);
   }
}
