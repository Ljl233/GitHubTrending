package com.example.githubtrending.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtrending.R;
import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.model.MyAdapter;
import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.ArrayList;
import java.util.List;

public class TrendingFragment extends Fragment implements TrendingContract.View {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<Bean> beans = new ArrayList<>(5);
    TrendingContract.Presenter mPresenter = new TrendingPresenter();

    static TrendingFragment INSTANCE = new TrendingFragment();

    private TrendingFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myAdapter = new MyAdapter(beans);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.trending_frag, container, false);
        recyclerView = root.findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myAdapter);
        mPresenter.refresh();
        return root;
    }

    static TrendingFragment getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void showItem(List<Bean> beans) {
        this.beans = beans;
        myAdapter.notifyDataSetChanged();
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
