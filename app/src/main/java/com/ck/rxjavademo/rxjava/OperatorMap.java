package com.ck.rxjavademo.rxjava;

import com.ck.rxjavademo.R;

import java.util.Map;

/**
 * 外包公司
 * 作用：提供农民工的角色，在apply方法中返回农民工
 */
public class OperatorMap<T, R> implements Operator<R, T>{

    Function<? super T, ? extends R> function;

    public OperatorMap(Function<? super T, ? extends R> function) {
        this.function = function;
    }

    /**
     * 返回农名工
     * @param observer 顾客（观察者）
     * @return
     */
    @Override
    public Observer<? extends T> apply(Observer<? super R> observer) {
        return new MapSubscrible<>(observer, function);
    }

    /**
     * 角色：农名工（观察者）
     * @param <T>
     * @param <R>
     */
    private class MapSubscrible<T, R> extends Observer<T> {

        private Observer<? super R> actual;

        private Function<? super T, ? extends R> transform;

        public MapSubscrible(Observer<? super R> actual, Function<? super T, ? extends R> transform) {
            this.actual = actual;
            this.transform = transform;
        }

        @Override
        public void onNext(T t) {

            //正在做转换的地方
            R r = transform.apply(t);
            actual.onNext(r);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete( ) {

        }
    }
}
