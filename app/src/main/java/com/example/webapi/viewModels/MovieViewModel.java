package com.example.webapi.viewModels;

import androidx.lifecycle.MutableLiveData;

import com.example.webapi.domain.MovieModel;

import java.util.List;

public class MovieViewModel {

    private MutableLiveData<List<MovieModel>> mMoviesMLD = new MutableLiveData<>();
}
