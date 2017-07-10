package com.demo.news.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.news.R;

public class NewContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_content);
        String title = getIntent().getStringExtra("news_title");
        String content = getIntent().getStringExtra("news_content");
        NewContentFragment fmNewsContent = (NewContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        fmNewsContent.refresh(title, content);
    }

    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent in = new Intent(context, NewContentActivity.class);
        in.putExtra("news_title", newsTitle);
        in.putExtra("news_content", newsContent);
        context.startActivity(in);
    }
}
