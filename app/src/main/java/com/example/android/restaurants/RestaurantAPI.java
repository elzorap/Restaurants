package com.example.android.restaurants;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantAPI {
    @GET("v3/c713138c-a305-4a1f-bd8e-38b533905013")
    Call<List<Restaurant>> getRestaurants();
}
