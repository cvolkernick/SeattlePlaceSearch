package com.example.cvolk.seattleplacesearch.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.cvolk.seattleplacesearch.R;
import com.example.cvolk.seattleplacesearch.model.FourSquareResponse;
import com.example.cvolk.seattleplacesearch.model.VenuesItem;
import com.example.cvolk.seattleplacesearch.utils.adapters.RecyclerListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    MainPresenter presenter;
    private RecyclerView rvSearchResults;

    List<VenuesItem> searchResultVenues = new ArrayList<>();
    private RecyclerListAdapter resultsListAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        presenter = new MainPresenter();
        presenter.attachView(this);

        presenter.getSearchResults();
    }

    // bind UI objects and adapters
    private void bindViews() {
        rvSearchResults = findViewById(R.id.rvSearchResults);

        //TODO: retrieve list of venus from api and assign to searchResultVenues
        // searchResultVenues = presenter.get

        resultsListAdapter = new RecyclerListAdapter(searchResultVenues);
        layoutManager = new LinearLayoutManager(this);

        rvSearchResults.setAdapter(resultsListAdapter);
        rvSearchResults.setLayoutManager(layoutManager);
    }

    @Override
    public void onSearchResults(FourSquareResponse response) {
        //TODO: populate the list with response data
        Log.d(TAG, "onSearchResults: " + response.toString());
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
