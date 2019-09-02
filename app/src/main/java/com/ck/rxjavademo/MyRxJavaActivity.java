package com.ck.rxjavademo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ck.rxjavademo.rxjava.Function;
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

        Obserable.create(new ObserableOnSubscribe<String>() {
            @Override
            public void subscribe(Observer<? super String> observer) {
                Log.d(TAG, "subscribe: 111");
                //隐试的递归
                observer.onNext("http://www.dongnao.head.png");
            }
        }).map(new Function<String, Bitmap>() {
            @Override
            public Bitmap apply(String s) {
                Log.d(TAG, "apply: " + s);
                return Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
            }
        }).subscrible(new Observer<Bitmap>() {
            @Override
            public void onNext(Bitmap bitmap) {
                Log.d(TAG, "onNext: 333" + bitmap);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

//        ObserableOnSubscribe<String> onSubscribe = new ObserableOnSubscribe<String>() {
//            @Override
//            public void subscribe(Observer<? super String> observer) {
//                observer.onNext(" --->");
//            }
//        };
//
//        Obserable<String> obserable = Obserable.create(onSubscribe);
//
//        Observer<String> observer = new Observer<String>() {
//            @Override
//            public void onNext(String s) {
//
//                Log.d(TAG, "onNext: " + s);
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//
//        obserable.subscrible(observer);


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
