package com.example.githubtrending.presenter;

import android.util.Log;

import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.model.TrendingRequest;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrendingPresenter implements TrendingContract.Presenter {

    TrendingContract.View mView;

    @Override
    public List<Bean> getData() {
        return null;
    }

    @Override
    public void request() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();


        TrendingRequest request = retrofit.create(TrendingRequest.class);

        Call<List<Bean>> call = request.grtCall();
        call.enqueue(new Callback<List<Bean>>() {
            @Override
            public void onResponse(Call<List<Bean>> call, Response<List<Bean>> response) {

                mView.showItem(response.body());
            }

            @Override
            public void onFailure(Call<List<Bean>> call, Throwable t) {
                Log.e("request on failure", t.getMessage());
            }
        });


    }


}
