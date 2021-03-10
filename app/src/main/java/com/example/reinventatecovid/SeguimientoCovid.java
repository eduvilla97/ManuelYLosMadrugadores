package com.example.reinventatecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SeguimientoCovid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguimiento_covid);
        WebView view = (WebView) findViewById(R.id.WebViewSeguimiento);
        view.setWebViewClient(new SeguimientoCovid.MyWebViewClient());
        view.loadUrl("https://quecovid.es/");
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl("https://quecovid.es/");
            return true;
        }
    }
}