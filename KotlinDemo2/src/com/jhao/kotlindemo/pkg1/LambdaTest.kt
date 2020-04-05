package com.jhao.kotlindemo.pkg1

import java.awt.Button

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe lambda 表达式
 *       总的来说，主要有 3 点：
 *        lambda 总是放在一个花括号里 ({})
 *        箭头左边是 lambda 参数 (lambda parameter)
 *        箭头右边是 lambda 体 (lambda body)
 *
 * functional interface:只有一个抽象方法，在 Java 中这样的接口被称作 functional interface 或 SAM (single abstract method)
 * 在 Kotlin 中，如果某个方法的参数是 Java 定义的 functional interface，Kotlin 支持把 lambda 当作参数进行传递的
 * */
fun main(args: Array<String>) {
    //在Kotlin中定义一个方法(重点在Kotlin中定义的)，参数类型是Java中的Runnable
    //Runnable是一个functional interface
    fun postDelay(runnable: Runnable) {
        runnable.run()
    }
    //把lambda当作参数传递是不允许的
    //postDelay(()->{
    //    println("postDelay")
    //})

    //在 Kotlin 中调用 Java 方法，能够将 lambda 当作参数传递，需要满足两个条件：
    //该 Java 方法的参数类型是 functional interface (只有一个抽象方法)
    //该 functional interface 是 Java 定义的，如果是 Kotlin 定义的，
    //就算该接口只有一个抽象方法，也是不行的
    postDelay(Runnable {
        run {
            println("postDelay")
        }
    })
    //  由此，我们做一个小结：
    //  个 lambda 对应一个内部类
    //  如果 lambda 体里没有使用外部变量，则调用方法时只会有一个内部类对象
    //  如果 lambda 体里使用了外部变量，则每调用一次该方法都会新建一个内部类对象

    //lambda 表达式赋值给变量
    //定义一个 lambda，赋值给一个变量
    var sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))
    //在 Kotlin 中常规的创建对象的方式(除了反射、序列化等)：
        //类名后面接括号，格式：className()
        //创建内部类对象，格式：object : className
        //SAM constructor 方式，格式：className{}

}

