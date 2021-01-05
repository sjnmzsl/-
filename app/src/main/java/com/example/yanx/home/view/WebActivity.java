package com.example.yanx.home.view;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yanx.R;

public class WebActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
//        https://cdwan.cn/pages/category/category?id=1005000
//        /pages/category/category?id=1005000
        web = (WebView) findViewById(R.id.web);
        String url = getIntent().getStringExtra("url");
        web.loadUrl("https://cdwan.cn/"+url);
        web.setWebViewClient(new WebViewClient());
    }
}