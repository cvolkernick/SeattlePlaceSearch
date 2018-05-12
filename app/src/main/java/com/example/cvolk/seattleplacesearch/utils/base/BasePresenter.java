package com.example.cvolk.seattleplacesearch.utils.base;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
