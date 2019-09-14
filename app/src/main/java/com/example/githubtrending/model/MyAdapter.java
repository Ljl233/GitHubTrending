package com.example.githubtrending.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtrending.R;
import com.example.githubtrending.model.Bean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Bean> beans;
    ImageView image;
    TextView tv_author;

    public MyAdapter(Context context, List<Bean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class ViewHolder1 extends RecyclerView.ViewHolder {
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_author = itemView.findViewById(R.id.author);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_author = itemView.findViewById(R.id.author);

        }
    }
}
