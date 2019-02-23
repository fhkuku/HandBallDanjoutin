package com.example.fernando.handballdanjoutin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.fernando.handballdanjoutin.R;

public class web_liens extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_liens);

        Bundle data = getIntent().getExtras();
        this.setTitle("Federation Hand Ball");
        if (data!=null){
            String url = data.getString("url");
            webView = findViewById(R.id.idweb);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);
            WebSettings webSettings =  webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }




    }
}
