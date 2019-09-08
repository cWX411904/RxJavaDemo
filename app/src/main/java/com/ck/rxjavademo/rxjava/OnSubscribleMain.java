package com.ck.rxjavademo.rxjava;

import android.os.Handler;
import android.os.Looper;

public class OnSubscribleMain<T> implements ObserableOnSubscribe<T> {

    private Handler handler;
    private Obserable<T> obserable;

    public OnSubscribleMain( Obserable<T> obserable) {
        handler = new Handler(Looper.getMainLooper());
        this.obserable = obserable;
    }

    @Override
    public void subscribe(final Observer<? super T> observer) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                //一定发生在主线程
                obserable.subscrible(observer);
            }
        });
    }
}
