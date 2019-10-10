package com.example.githubtrending.model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtrending.R;
import com.example.githubtrending.model.Bean;
import com.example.githubtrending.util.BitmapUtil;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private int theLastPosition = 0;
    private View theLastOnClickItem;
    private Context context;

    private static int mHiddenViewMeasuredHeight;
    private List<Bean> beans;


    public MyAdapter(List<Bean> bean) {
        //  this.context = context;
        this.beans = bean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mHiddenViewMeasuredHeight = (int) parent.getContext().getResources().getDimension(R.dimen.dp_40);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item, parent, false);
        return new ViewHolderFold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderFold vh = (ViewHolderFold) holder;
        vh.tv_author.setText(beans.get(position).getAuthor());
        vh.image.setImageBitmap(BitmapUtil.getBitmap(beans.get(position).getAvatar()));
        vh.name_project.setText(beans.get(position).getName());
        vh.item_description.setText(beans.get(position).getDescription());
        vh.language.setText(beans.get(position).getLanguage());
        vh.language.setTextColor(Color.parseColor(beans.get(position).getLanguageColor()));
        vh.fork.setText(String.valueOf(beans.get(position).getForks()));
        vh.star.setText(String.valueOf(beans.get(position).getStars()));
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (theLastOnClickItem != null && theLastOnClickItem.getVisibility() == View.VISIBLE) {
                    animClose(theLastOnClickItem);
                }
                if (vh.foldLayout.getVisibility() == View.GONE) {
                    animOpen(vh.foldLayout);

                } else {
                    animClose(vh.foldLayout);
                }
                theLastOnClickItem = vh.foldLayout;
            }
        });
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }


    class ViewHolderFold extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv_author, name_project, item_description, language, star, fork;
        LinearLayout foldLayout;

        public ViewHolderFold(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_author = itemView.findViewById(R.id.author);
            name_project = itemView.findViewById(R.id.item_project_name);
            item_description = itemView.findViewById(R.id.item_description);
            language = itemView.findViewById(R.id.language);
            star = itemView.findViewById(R.id.star);
            fork = itemView.findViewById(R.id.fork);
            foldLayout = itemView.findViewById(R.id.fold_item);
        }
    }

    private void animOpen(View view) {
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0);
        createDropAnim(view, 0, mHiddenViewMeasuredHeight).start();
    }

    private void animClose(final View view) {
        int origHeight = view.getHeight();
        view.setAlpha(1);
        ValueAnimator valueAnimator;
        valueAnimator = createDropAnim(view, origHeight, 0);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }
        });
        valueAnimator.start();
    }


    //动画
    private ValueAnimator createDropAnim(final View view, int start, int end) {
        final ValueAnimator va = ValueAnimator.ofInt(start, end);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();//根据时间因子的变化系数进行设置高度
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;

                float alpha = ((float) value) / mHiddenViewMeasuredHeight;
                view.setAlpha(alpha);

                view.setLayoutParams(layoutParams);//设置高度
            }
        });
        return va;
    }


}
