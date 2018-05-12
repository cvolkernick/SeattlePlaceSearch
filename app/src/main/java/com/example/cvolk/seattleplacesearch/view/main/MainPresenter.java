package com.example.cvolk.seattleplacesearch.view.main;

import com.example.cvolk.seattleplacesearch.utils.managers.RestManager;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getTestResponse() {
        RestManager restManager = RestManager.getInstance();

        restManager.TestSearchCall();
    }
}
