package com.example.cvolk.seattleplacesearch.view.main;

import com.example.cvolk.seattleplacesearch.utils.base.BasePresenter;
import com.example.cvolk.seattleplacesearch.utils.base.BaseView;

public interface MainContract {

    interface View extends BaseView {

        void onCheckPermission(boolean isEnabled);

    }

    interface Presenter extends BasePresenter<View> {

        void checkPermission();

    }
}
