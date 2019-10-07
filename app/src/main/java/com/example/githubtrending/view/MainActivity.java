package com.example.githubtrending.view;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtrending.R;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    public Toolbar toolbar;
    public RecyclerView recyclerView;
    public List<Bean> beans;
    TrendingPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

    }

    void initView() {
        initToolbar();
        TrendingFragment fragment = (TrendingFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        //初始化fragment
        if (fragment == null) {
            fragment = TrendingFragment.getINSTANCE();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, fragment);
            transaction.commit();
        }
        //初始化presenter
        mPresenter = new TrendingPresenter(fragment);
    }

    void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.inflateMenu(R.menu.toolbar_menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.sort_by_name) {
                        // sortByName();
                    } else {  // sortByStarts();
                    }
                    return true;
                }
            });
        }

    }

}
