package com.example.android.restaurants;

import android.view.View;

final /* synthetic */ class RestaurantsAdapter$$Lambda$0 implements View.OnClickListener {
    private final RestaurantsAdapter arg$1;
    private final RestaurantsAdapter.ItemViewHolder arg$2;
    private final int arg$3;

    RestaurantsAdapter$$Lambda$0(RestaurantsAdapter restaurantsAdapter, RestaurantsAdapter.ItemViewHolder itemViewHolder, int i) {
        this.arg$1 = restaurantsAdapter;
        this.arg$2 = itemViewHolder;
        this.arg$3 = i;
    }

    public void onClick(View view) {
        this.arg$1.lambda$onBindViewHolder$0$RestaurantsAdapter(this.arg$2, this.arg$3);
    }
}
