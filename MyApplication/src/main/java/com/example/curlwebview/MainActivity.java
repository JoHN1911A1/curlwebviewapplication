package com.example.curlwebview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private Context mContext;
    private WebView myWebView;
    private CustomWebViewClient customWebViewClient = new CustomWebViewClient();
    private Handler mNotifyHandler = null;
    private BackNotify mNotify = new BackNotify();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();

        if (mNotifyHandler == null) {
            mNotifyHandler = new Handler();
        }
        myWebView = new CustomWebView(mContext, mNotifyHandler);

        myWebView.setWebViewClient(customWebViewClient);
        setContentView(myWebView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        myWebView.loadUrl("http://oasis.mogya.com/sp/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 0, 0, "Google");
        menu.add(0, 1, 1, "IT TRICK");
        menu.add(0, 2, 2, "ERROR");
        menu.add(0, 3, 3, "ANIM");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int itemId = item.getItemId();
        switch(itemId) {
            case 0:
                myWebView.loadUrl("http://www.google.co.jp/");
                break;
            case 1:
                myWebView.loadUrl("http://it-trick-java.appspot.com/");
                break;
            case 2:
                myWebView.loadUrl("HTTPPP://TEST/");
                break;
            case 3:
                Intent intent = new Intent();
                intent.setClassName("example.testproj1", "example.testproj1.SampleAnimationActivity");
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //called when Back gesture is done while no more backward history
    public class BackNotify implements Runnable { //notify from nfWebView
        @Override
        public void run() {
            finish();
        }
    }
}