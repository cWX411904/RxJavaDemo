package com.ck.rxjavademo.rxjava;

/**
 * 服务员应该做什么事情
 */
public interface Action1<T> {

    /**
     * 通知厨师 开始做什么菜
     * @param t
     */
    void subscribe(T t);
}
