package com.example.reinventatecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NoticiasJ extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        WebView webview = (WebView) findViewById(R.id.WebView);
        webview.setWebViewClient(new NoticiasJ.MyWebViewClient());
        webview.loadUrl("https://principia.io/kids/");
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl("https://principia.io/kids/");
            return true;
        }
    }
}