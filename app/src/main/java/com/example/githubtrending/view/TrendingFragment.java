package com.example.githubtrending.view;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.githubtrending.R;
import com.example.githubtrending.TrendingContract;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.model.MyAdapter;
import com.example.githubtrending.presenter.TrendingPresenter;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class TrendingFragment extends Fragment implements TrendingContract.View {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private MyAdapter myAdapter;
    private List<Bean> beans = new ArrayList<>(5);
    private TrendingContract.Presenter mPresenter;

    private static TrendingFragment INSTANCE;

    private TrendingFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.trending_frag, container, false);
        recyclerView = root.findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);
        mPresenter.request();

        refreshLayout = root.findViewById(R.id.swipe_refresh_layout);
        //设置下拉进度的背景颜色，默认是白色。
        refreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        //设置下拉进度的主题颜色
        refreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        //下拉时触发下拉动画，动画完毕会回调这个方法
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadTasks(false);

            }
        });
        return root;
    }

    public static TrendingFragment getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new TrendingFragment();
        }
        return INSTANCE;
    }

    @Override
    public void showItem(List<Bean> beans) {
        this.beans = beans;
        Log.e("Fragment--------->", "I'm gonna to refresh");
        myAdapter = new MyAdapter(beans);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void setPresenter(TrendingPresenter mp) {
        mPresenter = checkNotNull(mp);
    }

    @Override
    public void setLoadingIndicator(final boolean action) {
        if (getView() == null) {
            return;
        }
        SwipeRefreshLayout srl = getView().findViewById(R.id.swipe_refresh_layout);
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(action);
            }
        });
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
