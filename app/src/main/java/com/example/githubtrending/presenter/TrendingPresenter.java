package com.example.githubtrending.presenter;

import android.util.Log;

import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.model.IModel;
import com.example.githubtrending.model.TrendingRequest;

import java.util.List;

import static androidx.core.util.Preconditions.checkNotNull;


public class TrendingPresenter implements TrendingContract.Presenter {

    TrendingContract.View mView;
    private IModel model = TrendingRequest.getINSTANCE();
    List<Bean> beans;

    @Override
    public List<Bean> getData() {
        beans = model.request();
        Log.e("Presenter--------->", model.toString());
        Log.e("Presenter--------->", beans.get(1).getAuthor());

        return beans;
    }

    @Override
    public void request() {
    }

    @Override
    public void unFold(int position) {

    }


}
