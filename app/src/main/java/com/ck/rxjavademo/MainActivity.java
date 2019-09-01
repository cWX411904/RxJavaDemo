package com.ck.rxjavademo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "wsj";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    Integer i = 10;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.每1s发送一个数据，从0开始，递增1，
        Observable.interval(1, TimeUnit.SECONDS)
                //2.通过takeUnit的Predicate传入判断条件
                .takeUntil(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        //返回true时，就停止发送事件
                        return (aLong > 3);
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.d(TAG, "onNext: 发送了事件 " + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //采用RxJava基于事件流的链式操作
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//
//            }
//            //采用flatMap（）变换操作符
//        }).flatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(Integer integer) throws Exception {
//                final List<String> list = new ArrayList<>();
//                for (int i = 0; i < 3; i++) {
//                    list.add("我是事件 " + integer + "拆分后的子事件" + i);
//                    //通过flatMap中将被观察者生产的事件序列先进行拆分，再将每个事件转换为一个新的发送三个String事件
//                    //最终合并，再发送给被观察者
//                }
//                return Observable.fromIterable(list).delay(10, TimeUnit.SECONDS);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d(TAG, "accept: s" + s);
//            }
//        });


//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//
//                e.onNext(1);
//                e.onNext(2);
//                e.onError(new Exception("发送错误了"));
//                e.onNext(3);
//            }
//        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
//
//                //返回新的被观察者Observable
//                //此处有两种情况：
//                //1.原始的Observable不重新发送事件：新的被观察者Observable发送的事件 = Error事件
//                //2.原始的Observable重新发送事件：新的被观察者Observable发送的时间= 数据事件
//                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
//                        //1. 若返回的Observable发送的事件 = Error事件，则原始的Observable不重新发送事件
////                        return Observable.error(new Throwable("retryWhen终止啦"));
//
//                        //2.若返回的Observable发送的事件 = 数据事件，则原始的Observable重新发送事件（若持续遇到错误，则持续重试）
//                        return Observable.just(1);
//                    }
//                });
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d(TAG, "onNext: 接收到了事件 " + integer);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//                Log.d(TAG, "onError: 对Error事件作出响应 " + e.toString());
//            }
//
//            @Override
//            public void onComplete() {
//
//                Log.d(TAG, "onComplete: 对Complete事件作出响应");
//            }
//        });

        Observable.combineLatest(
                Observable.intervalRange(0, 3, 0, 2, TimeUnit.SECONDS),
                Observable.intervalRange(0, 3, 0, 1, TimeUnit.SECONDS),
                new BiFunction<Long, Long, Long>() {
                    @Override
                    public Long apply(Long o1, Long o2) throws Exception {
                        //o1 = 第一个Observable发送的最新（最后）1个数据
                        //o2 = 第二个Observable发送的每一个数据
                        Log.d(TAG, "apply: 合并的数据是：" + o1 + " " + o2);
                        return o1 + o2;
                        //合并的逻辑=相加
                        //即第一个Observable发送的最后一个数据与第2个Observable发送的每一个数据进行相加
                    }
                }
        ).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.d(TAG, "accept: 合并的结果是：" + aLong);
            }
        });

    }
}




























