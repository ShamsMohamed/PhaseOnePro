package com.example.phaseoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AboutAlcActivity extends AppCompatActivity {

    private WebView mWebView;

    private ProgressBar mProgressBar;

    private static final String ANDELA_WEB_URL = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        mWebView = findViewById(R.id.web_view_about_alc);
        mProgressBar = findViewById(R.id.progress_bar);

        mProgressBar.setVisibility(View.VISIBLE);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100){
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });

        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.loadUrl(ANDELA_WEB_URL);

    }
}
