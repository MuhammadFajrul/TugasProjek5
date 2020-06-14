package com.example.tugasfive.Rest;

import com.example.tugasfive.Config.ServerConfig;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = ServerConfig.API_EBDPOINT;

    private static Retrofit retrofit= null;
    public static Retrofit getClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
    