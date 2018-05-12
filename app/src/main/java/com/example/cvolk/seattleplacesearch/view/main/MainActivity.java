package com.example.cvolk.seattleplacesearch.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cvolk.seattleplacesearch.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.attachView(this);

        presenter.getTestResponse();
    }

    @Override
    public void onGetTestResponse() {
        // do nothing, this is for test purposes
    }

    @Override
    public void showError(String error) {

    }
}
