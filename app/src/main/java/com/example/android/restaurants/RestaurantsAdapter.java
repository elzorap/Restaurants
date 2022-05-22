package com.example.android.restaurants;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.ItemViewHolder> {
    Context context;
    ArrayList<Restaurant> listOfRestaurants;

    public RestaurantsAdapter(Context context, ArrayList<Restaurant> listOfRestaurants) {
        this.listOfRestaurants = listOfRestaurants;
        this.context = context;
    }

    @NonNull
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurants_row, parent, false));
    }

    public int getItemCount() {
        return listOfRestaurants.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        ImageView image;
        TextView name;

        ItemViewHolder(@NonNull View view) {
            super(view);
            this.image = view.findViewById(R.id.ivRestaurant);
            this.name = view.findViewById(R.id.tvName);
            this.description = view.findViewById(R.id.tvDescription);
        }
    }

    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Restaurant restaurant = listOfRestaurants.get(position);
        Picasso.get().load(restaurant.getImagePath()).into(holder.image);
        holder.name.setText(restaurant.getName());
        holder.description.setText(restaurant.getDescription());
        holder.itemView.setOnClickListener(new RestaurantsAdapter$$Lambda$0(this, holder, position));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$RestaurantsAdapter(ItemViewHolder holder, int position) {
        Intent intent = new Intent(holder.itemView.getContext(), RestaurantsDetailes.class);
        intent.putExtra("restaurant", this.listOfRestaurants.get(position));
        holder.itemView.getContext().startActivity(intent);
    }
}
