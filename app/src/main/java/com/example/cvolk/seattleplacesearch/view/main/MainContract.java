package com.example.cvolk.seattleplacesearch.view.main;

import com.example.cvolk.seattleplacesearch.model.FourSquareResponse;
import com.example.cvolk.seattleplacesearch.utils.base.BasePresenter;
import com.example.cvolk.seattleplacesearch.utils.base.BaseView;

public interface MainContract {

    interface View extends BaseView {

        void onSearchResults(FourSquareResponse response);

    }

    interface Presenter extends BasePresenter<View> {

        void getSearchResults();

    }
}
