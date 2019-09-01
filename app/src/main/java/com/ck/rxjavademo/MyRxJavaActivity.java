package com.ck.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ck.rxjavademo.rxjava.Obserable;
import com.ck.rxjavademo.rxjava.ObserableOnSubscribe;
import com.ck.rxjavademo.rxjava.Observer;

import java.io.File;

public class MyRxJavaActivity extends AppCompatActivity {

    private static final String TAG = "wsj";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rx_java);

        ObserableOnSubscribe<String> onSubscribe = new ObserableOnSubscribe<String>() {
            @Override
            public void subscribe(Observer<? super String> observer) {
                observer.onNext(" --->");
            }
        };

        Obserable<String> obserable = Obserable.create(onSubscribe);

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onNext(String s) {

                Log.d(TAG, "onNext: " + s);

            }

            @Override
            public void onError(String s) {

            }

            @Override
            public void onComplete(String s) {

            }
        };

        obserable.subscrible(observer);


//        /**
//         * 响应式编程
//         * 链式调度
//         */
//        Obserable.create(new ObserableOnSubscribe<File>() {
//            @Override
//            public void subscribe(Observer<? super File> observer) {
//
//            }
//        }).subscrible(new Observer<File>() {
//            @Override
//            public void onNext(File file) {
//
//            }
//
//            @Override
//            public void onError(File file) {
//
//            }
//
//            @Override
//            public void onComplete(File file) {
//
//            }
//        });
    }
}
