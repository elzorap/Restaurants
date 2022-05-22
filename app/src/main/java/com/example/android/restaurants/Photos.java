package com.example.android.restaurants;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Photos implements Serializable {
    @SerializedName("imagePath")
    String imagePath;

    public Photos(String imagePath2) {
        this.imagePath = imagePath2;
    }
}
