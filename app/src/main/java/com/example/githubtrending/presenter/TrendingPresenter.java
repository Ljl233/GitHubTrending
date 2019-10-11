package com.example.githubtrending.presenter;

import android.util.Log;

import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.model.IModel;
import com.example.githubtrending.model.TrendingRequest;
import com.example.githubtrending.view.TrendingFragment;

import java.util.List;


public class TrendingPresenter implements TrendingContract.Presenter {

    private TrendingContract.View mView;
    private IModel model = TrendingRequest.getINSTANCE();
    private List<Bean> beans;

    //构造器
    public TrendingPresenter(TrendingContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public List<Bean> getData() {

//        Log.e("Presenter--------->", model.toString());
//        Log.e("Presenter--------->", beans.get(1).getAuthor());

        return beans;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadTasks(boolean forceUpdate) {
        loadTasks(forceUpdate, true);
    }

    private void loadTasks(boolean forceUpdate, boolean showLoadingUI) {

        mView.setLoadingIndicator(true);

        request();
    }

    @Override
    public void request() {
        model.request(new PCallback() {
            @Override
            public void requestFinish(List<Bean> beans) {
                Log.e("oPresenter--------->", "I'm going to show item");
                mView.showItem(beans);
            }
        });
    }

    @Override
    public void unFold(int position) {

    }


}

