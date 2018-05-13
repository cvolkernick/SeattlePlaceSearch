package com.example.cvolk.seattleplacesearch.view.details;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cvolk.seattleplacesearch.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends FragmentActivity implements DetailsContract.View, OnMapReadyCallback {

    private static final String TAG = DetailsActivity.class.getSimpleName() + "_TAG";

    DetailsPresenter presenter;

    //TODO: REFACTOR TO PRESENTER/MANAGER

    private GoogleMap mMap;
    private Location venueLocation;
    private String venueName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        venueLocation = getIntent().getParcelableExtra("venueLocation");
        venueName = getIntent().getStringExtra("venueName");

        //TODO: IMPLEMENT PRESENTER REFACTOR
        presenter = new DetailsPresenter();
        presenter.attachView(this);
    }

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
        LatLng venue = new LatLng(venueLocation.getLatitude(), venueLocation.getLongitude());
        coordinates.add(venue);
        mMap.addMarker(new MarkerOptions().position(venue).title(venueName)).showInfoWindow();

        // build marker bounds to fix zoom level
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (LatLng coordinate : coordinates) {
            builder.include(coordinate);
        }

        LatLngBounds bounds = builder.build();

        // adjust zoom
        CameraUpdate zoomer = CameraUpdateFactory.newLatLngBounds(bounds, 100);
        mMap.animateCamera(zoomer);
    }
}
