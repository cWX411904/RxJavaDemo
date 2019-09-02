package com.ck.rxjavademo.rxjava;

import android.support.annotation.NonNull;

public interface Function<T, R> {

    /**
     * 找到下一个观察者，为了去通知下一个观察者，然后调用内部方法
     * @param t
     * @return
     */
    R apply(T t);
}
