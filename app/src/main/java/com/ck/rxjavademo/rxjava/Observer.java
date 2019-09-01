package com.ck.rxjavademo.rxjava;

import java.util.concurrent.TimeUnit;

/**
 * 厨师
 * 事件的消费者
 */
public abstract class Observer<T> {

    public abstract void onNext(T t);
    public abstract void onError(T t);
    public abstract void onComplete(T t);
}
