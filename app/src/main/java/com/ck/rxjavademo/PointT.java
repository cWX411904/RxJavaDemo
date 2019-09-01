package com.ck.rxjavademo;

import java.io.Serializable;

public class PointT<T> {


    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    /**
     * extends 代表T的上界，这里的extends与常规的extends意义不一样
     * 有时候，我们会希望泛型类型只能是某一部分类型（比如Number）
     * 这个想法其实就是给泛型参数添加一个界限
     * 此处的extends表示子类型，不等同于继承
     * @param <T>
     * @return
     */
    public static <T extends Number& Serializable> T getNumber() {
        return null;
    }
}
