package com.example.fernando.handballdanjoutin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.fernando.handballdanjoutin.R;

public class pdf_liens extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_liens);

        String url ="https://gownetwork.com.mx/webservice/histoire.jpg";
        wv = findViewById(R.id.idwebs);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(url);

        WebSettings webSettings =  wv.getSettings();
        webSettings.getDisplayZoomControls();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
    }
}
