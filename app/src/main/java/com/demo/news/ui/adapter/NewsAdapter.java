package com.demo.news.ui.adapter;

import android.content.Context;
import android.icu.text.IDNA;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.news.R;
import com.demo.news.model.NewsEntity;

import java.util.List;

/**
 * Created by zzr on 2017/7/7.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<NewsEntity> newsList;
    private viewClick clickListener;

    public NewsAdapter(List<NewsEntity> newsList, viewClick clickListener) {
        this.newsList = newsList;
        this.clickListener = clickListener;
    }

    public void setNewsList(List<NewsEntity> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_list, parent, false);
        final NewsViewHolder viewHolder = new NewsViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.tvTitle.setText(newsList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;

        public NewsViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.news_title);
        }
    }

    public interface viewClick {
        void onClick(int position);
    }
}
