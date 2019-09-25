package com.example.githubtrending.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.MyAdapter;
import com.example.githubtrending.R;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TrendingContract.View {


    public Toolbar toolbar;
    public RecyclerView recyclerView;
    public List<Bean> beans;
    TrendingPresenter mPresenter = new TrendingPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toolbar = findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerview);
        initRecyclerView();

    }

    void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        beans = mPresenter.getData();
        showItem(beans);

    }


    @Override
    public void showItem(List<Bean> beans) {
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, beans);
        recyclerView.setAdapter(myAdapter);
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
