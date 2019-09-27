package com.example.githubtrending.model;

import android.util.Log;

import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrendingRequest implements IModel {

    private static TrendingRequest INSTANCE = null;

    public TrendingRequest() {

    }

    public static TrendingRequest getINSTANCE() {
        if (INSTANCE != null) {
            INSTANCE = new TrendingRequest();
        }
        return INSTANCE;
    }


    public List<Bean> beans = new ArrayList<>();
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://github-trending-api.now.sh/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private TrendingService service = retrofit.create(TrendingService.class);

    private Call<List<Bean>> serviceCall = service.getCall();

    public List<Bean> request() {
        Log.e("onResponse--------->", "msg");

        serviceCall.enqueue(new Callback<List<Bean>>() {

            @Override
            public void onResponse(Call<List<Bean>> call, Response<List<Bean>> response) {
                Log.e("onResponse--------->", beans.get(1).getAuthor());

                beans = response.body();
            }

            @Override
            public void onFailure(Call<List<Bean>> call, Throwable t) {
                Log.e("onResponse--------->", t.getMessage());

            }
        });
        Log.e("onResponse--------->", beans.get(1).getAuthor());

        return beans;
    }

}
