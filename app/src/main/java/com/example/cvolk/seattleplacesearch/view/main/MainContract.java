package com.example.cvolk.seattleplacesearch.view.main;

import com.example.cvolk.seattleplacesearch.utils.base.BasePresenter;
import com.example.cvolk.seattleplacesearch.utils.base.BaseView;

public interface MainContract {

    interface View extends BaseView {

        void onGetTestResponse();

    }

    interface Presenter extends BasePresenter<View> {

        void getTestResponse();

    }
}
