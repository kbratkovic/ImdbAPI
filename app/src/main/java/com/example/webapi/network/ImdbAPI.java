package com.example.webapi.network;

import com.example.webapi.network.response.SearchMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ImdbAPI {

    @GET("API/SearchMovie/{apiKey}/{expression}")
    Call<SearchMovieResponse> getMovieByTitle(
            @Path("apiKey") String apiKey,
            @Path("expression") String expression);

}
