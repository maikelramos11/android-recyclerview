package com.example.kevin.peliculasapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kevin on 22/11/2017.
 */

public class Client {

    public  static String BASE_URL = "http://api.themoviedb.org/3/";
    public  static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create ())
                    .build();



        }
        return retrofit;
    }
}