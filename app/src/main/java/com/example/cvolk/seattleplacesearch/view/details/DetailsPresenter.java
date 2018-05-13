package com.example.cvolk.seattleplacesearch.view.details;


public class DetailsPresenter implements DetailsContract.Presenter {

    DetailsContract.View view;

    @Override
    public void attachView(DetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void showStaticMap() {
        // TODO
    }
}
