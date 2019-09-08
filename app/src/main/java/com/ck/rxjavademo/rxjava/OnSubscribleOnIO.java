package com.ck.rxjavademo.rxjava;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OnSubscribleOnIO<T> implements ObserableOnSubscribe<T> {

    private static ExecutorService executorService = Executors.newCachedThreadPool();


    Obserable<T> source;

    public OnSubscribleOnIO(Obserable<T> source) {
        this.source = source;
    }

    @Override
    public void subscribe(final Observer<? super T> observer) {

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                source.subscrible(observer);
            }
        });
    }
}
