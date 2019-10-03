package com.example.githubtrending.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.MyAdapter;
import com.example.githubtrending.R;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.model.TrendingRequest;
import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.List;

import static androidx.core.util.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity {


    public Toolbar toolbar;
    public RecyclerView recyclerView;
    public List<Bean> beans;
    TrendingPresenter mPresenter = new TrendingPresenter();

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
        if (fragment == null) {
            fragment = TrendingFragment.getINSTANCE();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, fragment);
            transaction.commit();
        }
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

//    void initRecyclerView() {
//
//        recyclerView = findViewById(R.id.recyclerview);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(manager);
//        beans = mPresenter.getData();
//        // showItem(beans);
//
//    }
}
//
//
//    @Override
//    public void showItem(@NonNull List<Bean> beans) {
//        Log.e("MainActivity--------->", beans.get(1).getAuthor());
//        MyAdapter myAdapter = new MyAdapter(MainActivity.this, beans);
//        recyclerView.setAdapter(myAdapter);
//    }
//
//    @Override
//    public void showAddItem() {
//
//    }
//
//    @Override
//    public void showItemFold() {
//
//    }
//
//    @Override
//    public void showItemUnFold() {
//
//    }
//
//    @Override
//    public void showNoItem() {
//
//    }
//
//    @Override
//    public void showError() {
//
//    }
//
//
//    ItemListener mListener = new ItemListener() {
//        @Override
//        public void onItemClick() {
//            int position = 0;
//            mPresenter.unFold(position);
//        }
//    };
//
//    private interface ItemListener {
//        void onItemClick();
//
//    }
//}
