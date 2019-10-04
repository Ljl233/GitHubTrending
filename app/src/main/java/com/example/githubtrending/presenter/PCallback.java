package com.example.githubtrending.presenter;

import com.example.githubtrending.model.Bean;

import java.util.List;

public interface PCallback {
    void requestFinish(List<Bean> beans);
}
