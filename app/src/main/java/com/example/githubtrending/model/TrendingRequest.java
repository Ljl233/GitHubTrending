package com.example.githubtrending.model;

import android.util.Log;

import com.example.githubtrending.presenter.PCallback;
import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrendingRequest implements IModel {

    private static TrendingRequest INSTANCE = new TrendingRequest();

    private TrendingRequest() {

    }

    public static TrendingRequest getINSTANCE() {
        return INSTANCE;
    }


    List<Bean> beans = new ArrayList<>(10);
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://github-trending-api.now.sh/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private TrendingService service = retrofit.create(TrendingService.class);

    private Call<List<Bean>> serviceCall = service.getCall();

    public void request(PCallback pCallback) {

        serviceCall.enqueue(new Callback<List<Bean>>() {

            @Override
            public void onResponse(Call<List<Bean>> call, Response<List<Bean>> response) {
                Log.e("onResponse--------->", "success to request");
                pCallback.requestFinish(response.body());

            }
            @Override
            public void onFailure(Call<List<Bean>> call, Throwable t) {
                Log.e("onResponse--------->", t.getMessage());

            }
        });
    }

}
