package com.example.android.restaurants;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String API_URL = "https://run.mocky.io/";
    ArrayList<Restaurant> listOfRestaurants;
    public RecyclerView restaurants_recyclerview;
    Toolbar toolbar;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(this.toolbar);
        restaurants_recyclerview = findViewById(R.id.rvRestaurants);
        restaurants_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        getRestaurantsResponse();
    }

    private void getRestaurantsResponse() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        new Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(new OkHttpClient.Builder().addInterceptor(interceptor).build()).addConverterFactory(GsonConverterFactory.create()).build().create(RestaurantAPI.class).getRestaurants().enqueue(new Callback<List<Restaurant>>() {

            public void onResponse(@NotNull Call<List<Restaurant>> call, @NotNull Response<List<Restaurant>> response) {
                assert response.body() != null;
                listOfRestaurants = new ArrayList<>(response.body());
                RestaurantsAdapter adapter = new RestaurantsAdapter(MainActivity.this, listOfRestaurants);
                restaurants_recyclerview.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            public void onFailure(@NotNull Call<List<Restaurant>> call, @NotNull Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
