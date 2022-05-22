package com.example.android.restaurants;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class RestaurantsDetailes extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;
    private Restaurant restaurant;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    @RequiresApi(api = 19)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_detailes);
        this.toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(this.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Restaurant detailes");
        TextView name = findViewById(R.id.tvName);
        TextView description = findViewById(R.id.tvDescription);
        ((SupportMapFragment) Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.mapView))).getMapAsync(this);
        this.restaurant = (Restaurant) getIntent().getSerializableExtra("restaurant");
        if (this.restaurant != null) {
            populateGallery(this.restaurant.getPhotos());
            name.setText(this.restaurant.getName());
            description.setText(this.restaurant.getDescription());
        }
    }

    private void populateGallery(List<Photos> photos) {
        for (Photos photo : photos) {
            LinearLayout gallery = findViewById(R.id.gallery);
            View view = LayoutInflater.from(this).inflate(R.layout.item, gallery, false);
            gallery.addView(view);
            Picasso.get().load(photo.imagePath).resizeDimen(R.dimen.image_size, R.dimen.image_size).centerCrop().into((ImageView) view.findViewById(R.id.imageView));
        }
    }

    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.mMap = googleMap;
        setPoint(this.restaurant.getLatitude(), this.restaurant.getLongitude());
    }

    private void setPoint(double latitude, double longitude) {
        LatLng point = new LatLng(latitude, longitude);
        this.mMap.addMarker(new MarkerOptions().position(point).title(this.restaurant.getName()));
        this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 15.0f));
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(point, 15.0f));
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() != android.R.id.home) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
