package com.demo.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.news.R;

/**
 * Created by zzr on 2017/7/7.
 */

public class NewContentFragment extends Fragment {
    private View view;
    private TextView tvTitle;
    private TextView tvContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fm_new_content, container, false);
        return view;
    }

    public void refresh(String newsTitle, String newsContent) {
        LinearLayout layout = view.findViewById(R.id.visiable_layout);
        tvTitle = view.findViewById(R.id.news_title);
        tvContent = view.findViewById(R.id.news_content);
        layout.setVisibility(View.VISIBLE);
        tvTitle.setText(newsTitle);
        tvContent.setText(newsContent);

    }

}
