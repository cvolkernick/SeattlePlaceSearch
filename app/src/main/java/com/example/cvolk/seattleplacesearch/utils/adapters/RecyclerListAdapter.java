package com.example.cvolk.seattleplacesearch.utils.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cvolk.seattleplacesearch.R;
import com.example.cvolk.seattleplacesearch.model.CategoriesItem;
import com.example.cvolk.seattleplacesearch.model.Icon;
import com.example.cvolk.seattleplacesearch.model.Location;
import com.example.cvolk.seattleplacesearch.model.VenuesItem;
import com.example.cvolk.seattleplacesearch.utils.managers.SharedPrefManager;
import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {

    Context context;
    List<VenuesItem> venues;

    private final String ICON_CORE = "bg_88";

    public RecyclerListAdapter(List<VenuesItem> venues) { this.venues = venues; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.search_result_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VenuesItem venuesItem = venues.get(position);
        CategoriesItem category = venuesItem.getCategories().get(0);

        // bind views with data
        holder.tvName.setText(venuesItem.getName());

        // show category and icon if present
        if (category != null) {
            Icon venuIcon = category.getIcon();
            String iconUrl = getIconUrl(venuIcon);

            Glide.with(context)
                    .load(iconUrl)
                    .into(holder.ivIcon);

            holder.tvCategory.setText(category.getName());
        }

        // calculate distance from venue to center of Seattle & convert meters result to miles
        float distanceMeters = getDistanceFromSeattle(venuesItem.getLocation());
        double distanceMiles = distanceMeters * 0.000621371;

        // format distance in miles to 2 decimal places and display
        NumberFormat formatter = new DecimalFormat("#0.00");
        holder.tvDistance.setText(formatter.format(distanceMiles) + " miles away");

        // display favorite icon
        SharedPrefManager prefMan = SharedPrefManager.getInstance();

        if (prefMan.venueIsFavorite(context, venuesItem.getId())) {
            holder.ibFavorite.setImageResource(R.drawable.favorite_fill);
        }
        else {
            holder.ibFavorite.setImageResource(R.drawable.favorite_outline);
        }

        // store venue ID for favorites use
        holder.ibFavorite.setTag(venuesItem.getId());

        // store venue coordinates for details map user

        android.location.Location androidLocation = new android.location.Location("");
        androidLocation.setLatitude(venuesItem.getLocation().getLat());
        androidLocation.setLongitude(venuesItem.getLocation().getLng());

        holder.itemView.setTag(R.string.venueLocation, androidLocation);
        holder.itemView.setTag(R.string.venueName, venuesItem.getName());
    }

    @Override
    public int getItemCount() {
        return venues.size();
    }

    private float getDistanceFromSeattle(Location location) {

        // create android Location object for venue
        android.location.Location venueLocation = new android.location.Location("");
        venueLocation.setLatitude(location.getLat());
        venueLocation.setLongitude(location.getLng());

        // create android Location object for Seattle
        android.location.Location seattleCenter = new android.location.Location("");
        seattleCenter.setLatitude(47.6062);
        seattleCenter.setLongitude(-122.3321);

        // return distance from venue to center of Seattle
        return venueLocation.distanceTo(seattleCenter);
    }

    // construct an icon url from its parts
    private String getIconUrl(Icon icon) {
        return icon.getPrefix() + ICON_CORE + icon.getSuffix();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivIcon;
        private final TextView tvCategory;
        private final TextView tvName;
        private final TextView tvDistance;
        private final ImageButton ibFavorite;

        public ViewHolder(View itemView) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvName = itemView.findViewById(R.id.tvName);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            ibFavorite = itemView.findViewById(R.id.ibFavorite);
        }
    }
}
