package com.example.android.restaurants;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public final class Restaurant implements Serializable {
    @SerializedName("description")
    private final String description;
    @SerializedName("imagePath")
    private final String imagePath;
    @SerializedName("latitude")
    private final double latitude;
    @SerializedName("longitude")
    private final double longitude;
    @SerializedName("name")
    private final String name;
    @SerializedName("photos")
    private final List<Photos> photos;

    public Restaurant(String name2, String description2, String imagePath2, double latitude2, double longitude2, List<Photos> photos2) {
        this.name = name2;
        this.description = description2;
        this.imagePath = imagePath2;
        this.latitude = latitude2;
        this.longitude = longitude2;
        this.photos = photos2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public List<Photos> getPhotos() {
        return this.photos;
    }
}
