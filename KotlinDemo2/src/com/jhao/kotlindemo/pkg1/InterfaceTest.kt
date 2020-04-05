package com.jhao.kotlindemo.pkg1

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe Kotlin 中的 Interface
 * 在 Java8 之前，Interface 中是不能包含有方法体的方法和属性，只能包含抽象方法和常量。
 * 在 Kotlin 中的接口在定义的时候可以包含有方法体的方法，也可以包含属性
 */
//声明一个接口，包含方法体的方法 plus 和一个属性 count
interface InterfaceTest {
    var count: Int

    fun plus(num: Int) {
        count += num
    }
}

//实现该接口
class Impl : InterfaceTest {
    //必须要覆盖 count 属性
    override var count: Int = 0
//        get() = 0
//        set(value) {}
}

fun main(args: Array<String>) {
    var impl = Impl();
}