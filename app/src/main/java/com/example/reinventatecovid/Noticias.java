package com.example.reinventatecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Noticias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        WebView webview = (WebView) findViewById(R.id.WebView);
        webview.setWebViewClient(new MyWebViewClient());
        webview.loadUrl("https://ariadna.elmundo.es/buscador/archivo.html?q=Covid&t=1&n=10&fd=0&td=0&w=70&s=1&no_acd=1&sp=304");
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl("https://ariadna.elmundo.es/buscador/archivo.html?q=Covid&t=1&n=10&fd=0&td=0&w=70&s=1&no_acd=1&sp=304");
            return true;
        }
    }
}