package com.example.curlwebview;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by jun_nakahara on 13/08/06.
 */
public class CustomWebView extends WebView {
    Context context;
    GestureDetector gd;
    int gesture_stx,gesture_sty;
    private Handler notifyback_handler;
    private Runnable notifyback_listener;

//    public CustomWebView(Context context, Handler _handler, Runnable _listener) {
    public CustomWebView(Context context, Handler _handler) {
        super(context);
        this.context = context;
        gd = new GestureDetector(context, onGestureListener);
        notifyback_handler = _handler;
//        notifyback_listener = _listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return (gd.onTouchEvent(event) || super.onTouchEvent(event));
    }

    public void CallNotifyBackTakenHandler() {
//        notifyback_handler.post(notifyback_listener);
    }

    private final GestureDetector.SimpleOnGestureListener onGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d("nakahara","double tap");
            return super.onDoubleTap(e);
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("nakahara","double tap ev");
            return super.onDoubleTapEvent(e);
        }
        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("nakahara","onDown");
            return super.onDown(e);
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY) {
            Log.d("nakahara","fling");
            float deltax,deltay,velo;
            deltax = Math.abs(e1.getRawX()-e2.getRawX());
            deltay = Math.abs(e1.getRawY()-e2.getRawY());
            velo = Math.abs(velocityX);
            //pref_browser_gesturevelo is how fast finger moves.
            //pref_browser_gesturevelo set to 350 as default in my app
            if (deltax > 200 && deltay < 90 && velo > 350) {
                if (e1.getRawX() > e2.getRawX()) {
                    if (canGoForward()) {
                        //Gesture : move forward
                        goForward();
                    } else {
                        //Gesture : no more forward history
                    }
                } else if(e1.getRawX() < e2.getRawX()) {
                    if (canGoBack()) {
                        //Gesture : go back
                        goBack();
                    } else {
                        //Gesture : no more backward history, end browser
                        CallNotifyBackTakenHandler();
                    }
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
        @Override
        public void onLongPress(MotionEvent e) {
            Log.d("nakahara","long press");
            super.onLongPress(e);
        }
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d("nakahara","scroll");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        @Override
        public void onShowPress(MotionEvent e) {
            Log.d("nakahara","show press");
            super.onShowPress(e);
        }
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d("nakahara","single tap confirmed");
            return super.onSingleTapConfirmed(e);
        }
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d("nakahara","single tap up");
            return super.onSingleTapUp(e);
        }

    };
}
