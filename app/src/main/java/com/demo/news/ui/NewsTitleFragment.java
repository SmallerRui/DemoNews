package com.demo.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.news.R;
import com.demo.news.model.NewsEntity;
import com.demo.news.ui.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzr on 2017/7/7.
 */

public class NewsTitleFragment extends Fragment implements NewsAdapter.viewClick {
    private View view;
    private boolean isTwoPage;
    private List<NewsEntity> newsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fm_news_title_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView titleList = view.findViewById(R.id.title_list);
        isTwoPage = getActivity().findViewById(R.id.news_content_fragment) != null;
        initData();
        NewsAdapter newAdapter = new NewsAdapter(newsList, this);
        titleList.setLayoutManager(new LinearLayoutManager(getContext()));
        titleList.setAdapter(newAdapter);

    }

    private void initData() {
        NewsEntity entity = null;
        newsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            entity = new NewsEntity();
            entity.setTitle(String.format("这是第%d条标题!", i));
            entity.setContent("新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容");
            newsList.add(entity);
        }
    }

    @Override
    public void onClick(int position) {
        NewsEntity entity = newsList.get(position);
        if (isTwoPage) {
            NewContentFragment fmNewsContent = (NewContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
            fmNewsContent.refresh(entity.getTitle(), entity.getContent());
        } else {
            NewContentActivity.actionStart(getContext(), entity.getTitle(), entity.getContent());
        }
    }
}
