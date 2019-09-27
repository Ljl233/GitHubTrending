package com.example.githubtrending.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrendingService {
    @GET("repositories?language=&since=daily")
    Call<List<Bean>> getCall();
}
