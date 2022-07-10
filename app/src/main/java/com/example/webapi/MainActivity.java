package com.example.webapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.webapi.network.ApiCredentials;
import com.example.webapi.network.ImdbAPI;
import com.example.webapi.network.RetrofitService;
import com.example.webapi.network.response.SearchMovieResponse;
import com.example.webapi.databinding.ActivityMainBinding;
import com.example.webapi.domain.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ImdbAPI imdbAPI = RetrofitService.getImdbAPI();

        binding.buttonFindMovie.setOnClickListener(View -> {
            String title = binding.editTextMovieTitle.getText().toString();


            Call<SearchMovieResponse> call = imdbAPI.getMovieByTitle(ApiCredentials.API_KEY, title);
            call.enqueue(new Callback<SearchMovieResponse>() {
                @Override
                public void onResponse(Call<SearchMovieResponse> call, Response<SearchMovieResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                binding.textViewResponse.setText(title);

                                List<MovieModel> searchResults = response.body().getSearchResultList();
                                for (MovieModel item : searchResults) {
                                    Log.v("Tag", "Movie title: " + item.getTitle());
                                    Log.v("Tag", "Movie image: " + item.getDescription());
                                    Log.v("Tag", "Movie image: " + item.getImage());
                                }
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<SearchMovieResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });

        });
    }
}