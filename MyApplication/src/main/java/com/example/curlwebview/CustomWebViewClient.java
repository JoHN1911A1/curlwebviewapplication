package com.example.curlwebview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CustomWebViewClient extends WebViewClient {

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
    }

    @Override
    public void onPageFinished(WebView view, String url) {
    }

    @Override
    public void onReceivedError(WebView view, int errCode, String description, String failingUrl) {
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

}
