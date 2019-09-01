package com.ck.rxjavademo;

import java.util.ArrayList;
import java.util.List;

public class AppTest {

    public void main() {

        List<? extends Fruit> list = new ArrayList<>();

        //下面这行报错的原因是 用通配符 ？ extends 这样的写法，只能够取，不能够写
//        list.add(new Fruit());
        //理解一点：编译器只要能确定通配符类型，就允许写，否则就会报错。
        //只能取
        Fruit f = list.get(2);


        List<? super Fruit> list1 = new ArrayList<>();
        //? super  这样的写法，只能写，不能够读
        list1.add(new Banana());
//        Fruit object = list1.get(0);



    }

    public void main2(List<? super Fruit> src) {

//        for (int i = 0; i < src.size(); i++) {
////            src.add(dest.get(i))
//            dest.add(src.get(i));
//        }
    }

    public void main3() {

        List<Banana> bananas = new ArrayList<>();
    }

    /**
     * 食物
     */
    class Food{}

    /**
     * 水果
     */
    class Fruit extends Food {}

    /**
     * 香蕉
     */
    class Banana extends Fruit {}
}
