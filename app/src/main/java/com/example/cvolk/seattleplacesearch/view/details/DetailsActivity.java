package com.example.cvolk.seattleplacesearch.view.details;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cvolk.seattleplacesearch.R;
import com.example.cvolk.seattleplacesearch.model.VenuesItem;
import com.example.cvolk.seattleplacesearch.utils.managers.SharedPrefManager;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends FragmentActivity implements DetailsContract.View, OnMapReadyCallback {

    private static final String TAG = DetailsActivity.class.getSimpleName() + "_TAG";

    DetailsPresenter presenter;

    //TODO: REFACTOR TO PRESENTER/MANAGER

    private AppBarLayout mAppBarLayout;

    private GoogleMap mMap;
    private VenuesItem mVenue;
    private TextView tvName;
    private TextView tvWebsite;
    private ImageButton ibFavorite;
    private TextView tvAddress;
    private TextView tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mVenue = getIntent().getParcelableExtra("venue");

        //TODO: IMPLEMENT PRESENTER REFACTOR
        presenter = new DetailsPresenter();
        presenter.attachView(this);

        bindViews();
        displayDetails();
    }

    private void bindViews() {
        tvName = findViewById(R.id.tvName);
        tvCategory = findViewById(R.id.tvCategory);
        tvWebsite = findViewById(R.id.tvWebsite);
        mAppBarLayout = findViewById(R.id.app_bar_layout);
        ibFavorite = findViewById(R.id.ibFavorite);
        tvAddress = findViewById(R.id.tvAddress);
    }

    // display the clicked venue's details
    private void displayDetails() {

        // display venue name, category, address
        tvName.setText(mVenue.getName());

        if (mVenue.getCategories().get(0) != null) {
            tvCategory.setText(mVenue.getCategories().get(0).getName());
        }

        tvAddress.setText(
                mVenue.getLocation().getAddress() + "\n"
                        + mVenue.getLocation().getCity()
                        + ", " + mVenue.getLocation().getState()
                        + " " + mVenue.getLocation().getPostalCode()
        );

        //tvWebsite.setText(Html.fromHtml(buildVenueHyperlink(mVenue.getUrl())));
        tvWebsite.setMovementMethod(LinkMovementMethod.getInstance());

        // display favorite icon
        SharedPrefManager prefMan = SharedPrefManager.getInstance();

        if (prefMan.venueIsFavorite(this, mVenue.getId())) {
            ibFavorite.setImageResource(R.drawable.favorite_fill);
        }
        else {
            ibFavorite.setImageResource(R.drawable.favorite_outline);
        }
    }

    // build url string from venue url
    private String buildVenueHyperlink(String url) {
        return "<a href=" + url + ">Website</a>";
    }

    // TODO: move map work into presenter/manager
    @Override
    public void onShowStaticMap() {

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        List<LatLng> coordinates = new ArrayList<>();

        // add center of seattle marker
        LatLng seattle = new LatLng(47.6062, -122.3321);
        coordinates.add(seattle);
        mMap.addMarker(new MarkerOptions().position(seattle).title("Seattle, WA"));

        // add venue marker
        LatLng venue = new LatLng(mVenue.getLocation().getLat(), mVenue.getLocation().getLng());
        coordinates.add(venue);
        mMap.addMarker(new MarkerOptions().position(venue).title(mVenue.getName())).showInfoWindow();

        // build marker bounds to fix zoom level
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (LatLng coordinate : coordinates) {
            builder.include(coordinate);
        }

        final LatLngBounds bounds = builder.build();

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {

                int width = mAppBarLayout.getWidth();
                int height = mAppBarLayout.getHeight();

                // adjust zoom
                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, 50));
            }
        });
    }

    // update favorites sharedpref and toggle image accordingly
    public void toggleFavorite(View view) {

        SharedPrefManager prefMan = SharedPrefManager.getInstance();
        Context context = view.getContext();
        String id = mVenue.getId();
        ImageButton favoriteButton = (ImageButton)view;

        prefMan.toggleFavorite(context, id);

        if (prefMan.venueIsFavorite(context, id)) {
            favoriteButton.setImageResource(R.drawable.favorite_fill);
        }
        else {
            favoriteButton.setImageResource(R.drawable.favorite_outline);
        }
    }
}
