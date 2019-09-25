package com.example.githubtrending.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtrending.R;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.util.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Bean> beans;


    public MyAdapter(Context context, List<Bean> bean) {
        this.context = context;
        this.beans = bean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fold, parent, false);
        return new ViewHolder1(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 vh = (ViewHolder1) holder;
        vh.tv_author.setText(beans.get(position).getAuthor());
        vh.image.setImageBitmap(BitmapUtil.getBitmap(beans.get(position).getAvatar()));

    }

    @Override
    public int getItemCount() {
        return beans.size();
    }


    class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv_author;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_author = itemView.findViewById(R.id.author);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv_author;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_author = itemView.findViewById(R.id.author);


        }
    }
}
