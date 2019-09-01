package com.ck.rxjavademo;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
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
import io.reactivex.observables.GroupedObservable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "wsj";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    Integer i = 10;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Observable.just("header.png", "bit.png").map(new Function<String, Bitmap>() {
//
//            @Override
//            public Bitmap apply(String url) throws Exception {
//
//                //这里进行网络请求,将url转换为Bitmap
//                //这里先返回个假的Bitmap
//                return Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
//            }
//        }).subscribe(new Observer<Bitmap>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Bitmap bitmap) {
//                Log.d(TAG, "onNext: " + bitmap.toString());
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
//        });

//        /**
//         * 使用场景：当app登录前，必须先拿到app的配置
//         */
//        Observable.just("getConfig", "login").flatMap(new Function<String, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(String s) throws Exception {
//                return createResponse(s);
//            }
//
//            //链式调度，串行操作
//            private ObservableSource<?> createResponse(final String s) {
//                return Observable.create(new ObservableOnSubscribe<String>() {
//
//                    @Override
//                    public void subscribe(ObservableEmitter<String> e) throws Exception {
//                        e.onNext("登录 " + s);
//                    }
//                });
//            }
//        }).subscribe(
//                new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//                        Log.d(TAG, "onNext: o" + o.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /*
            比如 一堆书中分为语文书和英语书,现在想要将他们分为两组
         */
//        Observable.just(1,2,3,4).groupBy(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) throws Exception {
//
//                return integer > 2 ? "A组":"B组";
//            }
//        }).subscribe(new Consumer<GroupedObservable<String, Integer>>() {
//            @Override
//            public void accept(final GroupedObservable<String, Integer> stringIntegerGroupedObservable) throws Exception {
//
//                stringIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        String key = stringIntegerGroupedObservable.getKey();
//                        Log.d(TAG, "accept: key = " + key + ", integer " + integer);
//
//                    }
//                });
//
//            }
//        });

//        /**
//         * 适用于大型的数据分组，buffer里面的参数，是每个集合中的元素
//         */
//        Observable.just(1,2,3,4,5,6).buffer(2).subscribe(new Observer<List<Integer>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(List<Integer> integers) {
//                Log.d(TAG, "onNext: " + integers);
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
//        });

//        /**
//         * 比如多个文件合并成一个大文件
//         */
//        Observable.range(1, 5).scan(new BiFunction<Integer, Integer, Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) throws Exception {
//                return integer + integer2;
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                //上一个结果作为下一个参数，每次数字与上次结果相加
//                Log.d(TAG, "onNext: " + integer);
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
//        });

//        /**
//         * 过滤操作符
//         * 一堆商品中选出已经过期的商品，其他的不做处理
//         */
//        Observable.just(1,2,3,4,5,6).filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) throws Exception {
//                /**
//                 * true : 表示事件需要处理
//                 */
//                return integer > 2;
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//
//                Log.d(TAG, "onNext: " + integer);
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
//        });

//        /**
//         * take 过滤操作符
//         * 结合interval 做定时器，类似心跳
//         */
//        Observable.interval(1, TimeUnit.SECONDS)
//                //take里面的参数来限制执行的数量
//                .take(5)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Log.d(TAG, "onNext: " + aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

//        /**
//         * distinct操作符过滤掉重复的事件
//         */
//        Observable.just(1,2,2,3,4,6).distinct().subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//
//                Log.d(TAG, "onNext: " + integer);
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
//        });


//        /**
//         * all 条件操作符
//         *
//         */
//        Observable.just(1,2,3,4,5).all(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) throws Exception {
//                //判断是否事件中全部大于2
//                return integer > 2;
//            }
//        }).subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) throws Exception {
//                Log.d(TAG, "accept: " + aBoolean);
//            }
//        });

//        /**
//         * contains
//         * 判断被观察者是否包含某一个元素
//         */
//        Observable.just(1,3,4).contains(3).subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) throws Exception {
//                Log.d(TAG, "accept: " + aBoolean);
//            }
//        });
//
//        Observable.just(1,3,4).any(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) throws Exception {
//                return false;
//            }
//        }).subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) throws Exception {
//
//            }
//        });

//        Observable.intervalRange(0, 5, 0 , 10, TimeUnit.SECONDS)
//                .skipWhile(new Predicate<Long>() {
//                    @Override
//                    public boolean test(Long aLong) throws Exception {
//                        return aLong< 2;
//                    }
//                }).subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                Log.d(TAG, "accept: aLong = " + aLong );
//            }
//        });

//        /**
//         * startWith 合并操作符
//         * 增加一个新的被观察者
//         */
//        Observable.just(3,5,6).startWith(Observable.just(7,8,9)).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.d(TAG, "accept: integer " + integer);
//            }
//        });

//        /**
//         * concat最多四个
//         */
//        Observable.concat(
//                Observable.just(1,2,3),
//                Observable.just(4,5,6))
//                .subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.d(TAG, "accept: " + integer);
//            }
//        });

//        /**
//         * merge
//         */
//        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4);
//        Observable<Integer> observable2 = Observable.just(5, 6);
//        Observable<Integer> observable3 = Observable.just(7,8,9);
//
//        Observable.merge(observable3, observable1, observable2).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.d(TAG, "accept: " + integer);
//            }
//        });

//        /**
//         * merge 并发执行
//         */
//        Flowable.merge(
//                Flowable.intervalRange(0, 4, 1, 1, TimeUnit.SECONDS),
//                Flowable.intervalRange(4, 4, 1, 1, TimeUnit.SECONDS))
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.d(TAG, "accept: " + aLong);
//                    }
//                });

//        /**
//         * mergeDelayError 等待正常事件执行结束之后，再执行错误的异常
//         */
//        Flowable.mergeDelayError(
//                Flowable.create(new FlowableOnSubscribe<Publisher<?>>() {
//            @Override
//            public void subscribe(FlowableEmitter<Publisher<?>> e) throws Exception {
//                e.onError(new NullPointerException());
//
//            }
//        }, BackpressureStrategy.BUFFER),
//                Flowable.intervalRange(3, 3, 1, 1, TimeUnit.SECONDS)
//        ).subscribe(new Consumer<Object>() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d(TAG, "accept: " + o);
//            }
//        });

        Flowable.zip(
                Flowable.just(1, 2, 3),
                Flowable.just(4, 5),
                new BiFunction<Integer, Integer, Object>() {
                    @Override
                    public Object apply(Integer integer, Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d(TAG, "accept: " + o);
            }
        });




        //1.每1s发送一个数据，从0开始，递增1，
//        Observable.interval(1, TimeUnit.SECONDS)
//                //2.通过takeUnit的Predicate传入判断条件
//                .takeUntil(new Predicate<Long>() {
//                    @Override
//                    public boolean test(Long aLong) throws Exception {
//                        //返回true时，就停止发送事件
//                        return (aLong > 3);
//                    }
//                }).subscribe(new Observer<Long>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Long aLong) {
//                Log.d(TAG, "onNext: 发送了事件 " + aLong);
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
//        });

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

//        Observable.combineLatest(
//                Observable.intervalRange(0, 3, 0, 2, TimeUnit.SECONDS),
//                Observable.intervalRange(0, 3, 0, 1, TimeUnit.SECONDS),
//                new BiFunction<Long, Long, Long>() {
//                    @Override
//                    public Long apply(Long o1, Long o2) throws Exception {
//                        //o1 = 第一个Observable发送的最新（最后）1个数据
//                        //o2 = 第二个Observable发送的每一个数据
//                        Log.d(TAG, "apply: 合并的数据是：" + o1 + " " + o2);
//                        return o1 + o2;
//                        //合并的逻辑=相加
//                        //即第一个Observable发送的最后一个数据与第2个Observable发送的每一个数据进行相加
//                    }
//                }
//        ).subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                Log.d(TAG, "accept: 合并的结果是：" + aLong);
//            }
//        });

    }
}




























