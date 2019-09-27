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
        return new ViewHolderFold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderFold vh = (ViewHolderFold) holder;
        vh.tv_author.setText(beans.get(position).getAuthor());
        vh.image.setImageBitmap(BitmapUtil.getBitmap(beans.get(position).getAvatar()));
        vh.name_project.setText(beans.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }


    class ViewHolderFold extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv_author;
        TextView name_project;

        public ViewHolderFold(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_author = itemView.findViewById(R.id.author);
            name_project = itemView.findViewById(R.id.item_project_name);
        }
    }

    class ViewHolderUnfold extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv_author;
        TextView description, language, star, fork;

        public ViewHolderUnfold(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.item_description);
            language = itemView.findViewById(R.id.language);
            star = itemView.findViewById(R.id.star);
            fork = itemView.findViewById(R.id.fork);


        }
    }
}
