package com.example.githubtrending.presenter;

import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.model.IModel;
import com.example.githubtrending.model.TrendingRequest;

import java.util.List;


public class TrendingPresenter implements TrendingContract.Presenter {

    TrendingContract.View mView;
    IModel model = new TrendingRequest();
    List<Bean> beans;

    @Override
    public List<Bean> getData() {
        beans = model.request();
        return beans;
    }

    @Override
    public void request() {
    }


}
