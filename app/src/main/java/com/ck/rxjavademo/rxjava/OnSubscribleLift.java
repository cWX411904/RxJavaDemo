package com.ck.rxjavademo.rxjava;


/**
 * 角色：造纸厂的制作部门
 * RxJava的发射器
 * 发射器与发射器之间的引用，不是一个环与另一个环的直接引用
 */
public class OnSubscribleLift<T, R> implements ObserableOnSubscribe<R> {

    //人民日报的发射器
    ObserableOnSubscribe<T> parent;

    //外包公司
    Operator<? extends R, ? super T> operator;

    public OnSubscribleLift(ObserableOnSubscribe<T> parent, Function<? super T, ? extends R> function) {
        this.parent = parent;
        this.operator = new OperatorMap<T, R>(function);
    }

    @Override
    public void subscribe(Observer<? super R> observer) {

        Observer<? super T> st = (Observer<? super T>) operator.apply(observer);

        parent.subscribe(st);

    }
}
