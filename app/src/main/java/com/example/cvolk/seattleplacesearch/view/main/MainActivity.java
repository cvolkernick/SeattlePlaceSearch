package com.example.cvolk.seattleplacesearch.view.main;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cvolk.seattleplacesearch.R;
import com.example.cvolk.seattleplacesearch.model.FourSquareResponse;
import com.example.cvolk.seattleplacesearch.model.VenuesItem;
import com.example.cvolk.seattleplacesearch.utils.adapters.RecyclerListAdapter;
import com.example.cvolk.seattleplacesearch.utils.managers.SharedPrefManager;
import com.example.cvolk.seattleplacesearch.view.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    MainPresenter presenter;
    private RecyclerView rvSearchResults;

    List<VenuesItem> searchResultVenues = new ArrayList<>();
    private RecyclerListAdapter resultsListAdapter;
    private LinearLayoutManager layoutManager;
    private EditText etQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        presenter = new MainPresenter();
        presenter.attachView(this);
    }

    // bind UI objects and adapters
    private void bindViews() {
        etQuery = findViewById(R.id.etQuery);
        rvSearchResults = findViewById(R.id.rvSearchResults);

        resultsListAdapter = new RecyclerListAdapter(searchResultVenues);
        layoutManager = new LinearLayoutManager(this);

        rvSearchResults.setAdapter(resultsListAdapter);
        rvSearchResults.setLayoutManager(layoutManager);
    }

    // clear any existing results, add new results and update list
    @Override
    public void onSearchResults(FourSquareResponse response) {
        searchResultVenues.clear();
        searchResultVenues.addAll(response.getResponse().getVenues());
        resultsListAdapter.notifyDataSetChanged();
    }

    // show error(s) in toast if present
    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    // update favorites sharedpref and toggle image accordingly
    public void toggleFavorite(View view) {

        SharedPrefManager prefMan = SharedPrefManager.getInstance();
        Context context = view.getContext();
        String id = view.getTag().toString();
        ImageButton favoriteButton = (ImageButton)view;

        prefMan.toggleFavorite(context, id);

        if (prefMan.venueIsFavorite(context, id)) {
            favoriteButton.setImageResource(R.drawable.favorite_fill);
        }
        else {
            favoriteButton.setImageResource(R.drawable.favorite_outline);
        }
    }

    // submit query with entered search text; if no text present show error message in toast
    public void submitSearchQuery(View view) {

        String query = etQuery.getText().toString();

        if (!query.equals("")) {
            presenter.getSearchResults(query);
        }
        else {
            Toast.makeText(this, "Enter a search query.", Toast.LENGTH_SHORT).show();
        }
    }

    public void viewDetails(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("venueLocation", (Location)view.getTag(R.string.venueLocation));
        intent.putExtra("venueName", (String)view.getTag(R.string.venueName));

        startActivity(intent);
    }
}
