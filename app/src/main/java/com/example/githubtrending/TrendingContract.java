package com.example.githubtrending;

import com.example.githubtrending.model.Bean;
import com.example.githubtrending.presenter.PCallback;
import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.List;

public interface TrendingContract {

    interface View {
        void showItem(List<Bean> beans);

        void setPresenter(TrendingPresenter mp);

        void showAddItem();

        void showItemFold();

        void showItemUnFold();

        void showNoItem();

        void showError();


    }

    interface Presenter {
        List<Bean> getData();


        void refresh();

        void request();

        void unFold(int position);
    }

}
