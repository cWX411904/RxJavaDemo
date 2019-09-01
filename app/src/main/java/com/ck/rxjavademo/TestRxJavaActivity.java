package com.ck.rxjavademo;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TestRxJavaActivity extends AppCompatActivity {

    private static final String TAG = "wsj";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rx_java);

//        Observable.just("head.png", "icon.png")
//                .map(new Function<String, Bitmap>() {
//                    @Override
//                    public Bitmap apply(String s) throws Exception {
//                        //网络获取bitmap
//                        Log.d(TAG, "apply: 1111 " + Thread.currentThread().getName());
//                        return Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
//                    }
//                })
//                //subscribeOn 表示上面的apply方法是在子线程
//                .subscribeOn(Schedulers.io())
//                //observeOn 表示accept方法是在主线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Bitmap>() {
//                    @Override
//                    public void accept(Bitmap bitmap) throws Exception {
//                        Log.d(TAG, "accept: 222 " + Thread.currentThread().getName());
//                    }
//                });


//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                for (int i = 0; i < 10000; i++) {
//                    if (i == 2) {
//                        e.onError(new Throwable("出现错误了"));
//                    } else {
//                        e.onNext(" " + i);
//                    }
//                }
//            }
//        }).onErrorReturn(new Function<Throwable, String>() {
//            @Override
//            public String apply(Throwable throwable) throws Exception {
//                //拦截到错误之后，返回一个结果发射，
//                Log.d(TAG, "apply: 拦截到错误 " + throwable.toString());
//                return "错误的弥补";
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d(TAG, "accept: " + s);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                Log.d(TAG, "accept: 这里处理错误 " + throwable.toString());
//            }
//        });
//
//        Observable.create(new ObservableOnSubscribe<Object>() {
//            @Override
//            public void subscribe(ObservableEmitter<Object> e) throws Exception {
//                for (int i = 0; i < 5 ; i++) {
//                    if (i == 2) {
//                        e.onError(new Throwable("出现onError"));
//                    }
//                }
//            }
//        }).onErrorResumeNext(new Function<Throwable, ObservableSource<?>>() {
//            //
//            @Override
//            public ObservableSource<?> apply(Throwable throwable) throws Exception {
//                return Observable.just("重新定义了被观察者2", "重新定义了被观察者3", "重新定义了被观察者3");
//            }
//        }).subscribe(new Consumer<Object>() {
//            @Override
//            public void accept(Object o) throws Exception {
//
//            }
//        });
    }
}
