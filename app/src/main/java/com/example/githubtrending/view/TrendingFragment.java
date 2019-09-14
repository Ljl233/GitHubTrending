package com.example.githubtrending.view;

import androidx.fragment.app.Fragment;

import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.Bean;

import java.util.List;

public class TrendingFragment extends Fragment implements TrendingContract.View {

    public TrendingFragment() {

    }

    static TrendingFragment newInstance() {
        return new TrendingFragment();
    }

    @Override
    public void showItem(List<Bean> beans) {

    }

    @Override
    public void showAddItem() {

    }

    @Override
    public void showItemFold() {

    }

    @Override
    public void showItemUnFold() {

    }

    @Override
    public void showNoItem() {

    }

    @Override
    public void showError() {

    }
}
