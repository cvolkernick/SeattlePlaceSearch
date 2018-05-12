package com.example.cvolk.seattleplacesearch.view.main;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;

    @Override
    public void checkPermission() {

    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
