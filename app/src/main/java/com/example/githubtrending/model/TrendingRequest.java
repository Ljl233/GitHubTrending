package com.example.githubtrending.model;

import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrendingRequest implements IModel {
    public List<Bean> beans;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://github-trending-api.now.sh/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private TrendingService service = retrofit.create(TrendingService.class);

    private Call<List<Bean>> serviceCall = service.getCall();

    public List<Bean> request() {

        serviceCall.enqueue(new Callback<List<Bean>>() {
            @Override
            public void onResponse(Call<List<Bean>> call, Response<List<Bean>> response) {
                beans = response.body();
            }

            @Override
            public void onFailure(Call<List<Bean>> call, Throwable t) {

            }
        });

        return beans;
    }
}
