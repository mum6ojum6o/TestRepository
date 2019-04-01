package com.retrofit_example.anddevolver.geniusplaza.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit mRetrofit;
    private static final String BASE_URL="https://reqres.in/api/";
    public static Retrofit getInstance(){
        if(mRetrofit==null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
