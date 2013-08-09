package com.example.curlwebview;

import android.app.Activity;
import android.os.Bundle;

public class SampleAnimationActivity extends Activity {

      @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.main);
        }

        @Override
        public void onDestroy(){
            super.onDestroy();
            System.gc();
            finish();
        }
}