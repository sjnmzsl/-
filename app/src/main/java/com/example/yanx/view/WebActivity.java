package com.example.yanx.view;

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
        web = (WebView) findViewById(R.id.web);
        String url = getIntent().getStringExtra("url");
        web.loadUrl(url);
        web.setWebViewClient(new WebViewClient());
    }
}