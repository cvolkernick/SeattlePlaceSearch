package com.example.cvolk.seattleplacesearch.view.details;

import com.example.cvolk.seattleplacesearch.model.FourSquareResponse;
import com.example.cvolk.seattleplacesearch.utils.base.BasePresenter;
import com.example.cvolk.seattleplacesearch.utils.base.BaseView;
import com.example.cvolk.seattleplacesearch.view.main.MainContract;

public interface DetailsContract {

    interface View extends BaseView {

        void onShowStaticMap();

    }

    interface Presenter extends BasePresenter<DetailsContract.View> {

        void showStaticMap();

    }
}
