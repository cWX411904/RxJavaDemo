package com.ck.rxjavademo.rxjava;

public interface Operator<T, R> extends Function<Observer<? super T>, Observer<? extends R>> {
}
