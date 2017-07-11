package com.auribises.gwbactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActivity extends AppCompatActivity {

    WebView webView;
    String url = "http://aajtak.intoday.in/";

    void initWeb(){

        webView = (WebView)findViewById(R.id.webView);

        // Load URL in WebView
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url); // This needs internet connectivity. You must grant permission in the Manifest File
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initWeb();
    }
}
