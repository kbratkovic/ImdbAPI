package com.example.webapi.network.response;

import com.example.webapi.domain.MovieModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchMovieResponse {

    @SerializedName("results")
    private List<MovieModel> searchResultList;

    public List<MovieModel> getSearchResultList() {
        return searchResultList;
    }
}
