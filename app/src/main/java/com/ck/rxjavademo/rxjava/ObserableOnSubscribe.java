package com.ck.rxjavademo.rxjava;

/**
 * 服务员
 * 服务员跟厨师打交道
 * ? super T :
 *
 * 服务员知道顾客要吃什么了，就拿着菜单去找厨师，那么厨师就持有了顾客需要吃的菜品
 */
public interface ObserableOnSubscribe<T> extends Action1<Observer<? super T>> {
}
