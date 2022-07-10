package com.example.webapi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiCredentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static ImdbAPI imdbAPI = retrofit.create(ImdbAPI.class);

    public static ImdbAPI getImdbAPI(){
        return imdbAPI;
    }

}
