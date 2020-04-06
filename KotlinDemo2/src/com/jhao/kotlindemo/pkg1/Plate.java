package com.jhao.kotlindemo.pkg1;

/**
 * @author JiangHao
 * @date 2020/4/6
 * @describe Java中的泛型
 * Java 泛型：不变性 (invariance)、协变性 (covariance)、逆变性 (contravariance)
 * 可以总结为：PECS(Producer Extends, Consumer Super)
 */
//定义一个`盘子`类
public class Plate<T> {
    private T item;

    public Plate(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }

}

//食物
class Food1 {

}

//水果类
class Fruit1 extends Food1 {
}

//水果类
class Apple1 extends Fruit1 {
}

class Test {

//    private static void takeFruit(Plate<Fruit> plate) {
//
//    }

    //1) 协变性
    //假设我就要把一个装着苹果的盘子赋值给一个装着水果的盘子呢
    //在 Java 中把 ? extends Type 类似这样的泛型，称之为 上界通配符(Upper Bounds Wildcards)
    //因为 Plate<? extends Fruit>，可以存放 Fruit 和它的子类们，最高到 Fruit 类为止。所以叫上界通配符
    //发现 takeFruit() 的参数 plate 的 set 方法不能使用了，只有 get 方法可以使用。
    private static void takeFruitCovariance(Plate<? extends Fruit1> plate) {
        //plate.set(new Fruit());//编译报错
        //plate.set(new Apple());//编译报错
        Fruit1 fruit = plate.get();//编译正常
    }

    //2) 逆变性
    //我们把类似 ? super Type 这样的泛型，称之为下界通配符(Lower Bounds Wildcards)
    //顾名思义就是能存放 该类型和它的父类们
    private static void takeFruitContravariance(Plate<? super Fruit1> plate) {
        plate.set(new Fruit1());//编译正常
        plate.set(new Apple1());//编译正常
        //Fruit fruit = plate.get();//编译报错
        Object object = plate.get();
    }

    public static void main(String[] args) {
        //takeFruit(new Plate<Food>(new Fruit()));//泛型之不变(invariance)
        //1) 协变性
        takeFruitCovariance(new Plate<Fruit1>(new Apple1()));
    }
    //我们在回到刚刚说到的 set 和 get 方法：
    // set 方法的参数是该泛型；get 方法的返回值是该泛型
    //上界通配符 (extends)，只允许获取 (get)，不允许修改 (set)。可以理解为只生产(返回给别人用)，不消费。
    //下界通配符 (super)，只允许修改 (set)，不允许获取 (get)。可以理解为只消费 (set 方法传进来的参数可以使用了)，不生产。
    //可以总结为：PECS(Producer Extends, Consumer Super)
}