package com.ck.rxjavademo.rxjava;

/**
 * 顾客(被观察者)
 * 需求的发起者，
 * 他想要去饭店吃饭，通知ObserableOnSubscribe服务员让她知道我要吃什么
 * @param <T>
 */
public class Obserable<T> {

    private ObserableOnSubscribe obserableOnSubscribe;

    //保存
    private Obserable(ObserableOnSubscribe onSubscribe) {
        this.obserableOnSubscribe = onSubscribe;
    }

    //创造操作符 create
    public static <T> Obserable<T> create(ObserableOnSubscribe<T> subscribe) {

        return new Obserable<T>(subscribe);

    }

    /**
     * ? super T  ： 只能存，
     * @param observer
     */
    public void subscrible(Observer<? super T> observer) {
        obserableOnSubscribe.subscribe(observer);
    }
}
