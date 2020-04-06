package com.jhao.kotlindemo.pkg1

import java.util.function.Function

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe 高阶函数: 如果某个函数是以另一个函数作为参数或者返回值是一个函数，我们把这样的函数称之为高阶函数
 *
 *  function type,它的格式如下
 * 名称 : (参数) -> 返回值类型
 *          冒号左边是 function type 的名字
 *          冒号右边是参数
 *          尖括号右边是返回值
 *
 *  kotlin内置的一些的高阶函数如 let、run、with、apply，它们都是内联函数，使用 inline 关键字修饰
 *  内联 inline 是什么意思呢？
 *  就是在调用 inline 函数的地方，编译器在编译的时候会把内联函数的逻辑拷贝到调用的地方。
 *
 *  高阶函数的优化：
 *  在调用高阶函数的时候 ，会生成一个内部类。
 *  如果这个高阶函数被程序中很多地方调用了，那么就会有很多的内部类，那么程序的体积就会变得不可控了。
 *  而且如果调用高阶函数的时候，lambda 体里使用了外部变量，则会每次都会创建新的对象(内部类FunctionN实例),而不是 INSTANCE 常量实例。
 */
fun process(x: Int, y: Int, operate: (Int, Int) -> Int) {
    println(operate(x, y))
}
//编译后代码如下：
//public static final void process(int x, int y, @NotNull Function2 operate) {
//   Intrinsics.checkParameterIsNotNull(operate, "operate");
//   int var3 = ((Number)operate.invoke(x, y)).intValue();
//   System.out.println(var3);
//}

fun main(args: Array<String>) {
    var operate = { x: Int, y: Int -> x + y }
    process(1, 2, { x: Int, y: Int -> x + y })
    //常用的 forEach 也是高阶函数：
    val list = listOf<Int>(1, 2, 3)
    list.forEach { t -> println(t) }
    //forEach源码
    //public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
    //    for (element in this) action(element)
    //}
    //调用高阶函数时，lambda 参数是由 function type 的参数决定的
    fun <T> Iterable<T>.foreachCus(action: (T) -> Unit): Unit {
        for (element in this) {
            action(element)
        }
    }
    list.foreachCus { element ->
        println(" > " + element)
    }
    fun func1() = StringBuilder().apply {
        for (letter in 'A'..'Z') {

        }
    }

    //除了 apply，函数 with、run 的 lambda 参数都是 this
    //public inline fun <T> T.apply(block: T.() -> Unit): T
    fun alphabet1() = StringBuilder().apply {
        for (letter in 'a'..'z') {
//            println(letter)
            //可以直接调用StringBuiulder的方法
            append(letter)
        }
        append("\nNow I know the alphabet!")
    }

    //public inline fun <T, R> T.run(block: T.() -> R): R
    fun alphabet2() = StringBuilder().run {
        for (letter in 'a'..'z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
    }

    /**
     * Lambda argument should be moved out of parentheses less... (Ctrl+F1)
     * Inspection info: This inspection detects a lambda expression inside parentheses which can be moved outside of them.
     * 这种把block块写在括号内的写法也可以编译通过，但是会建议到出括号外，看起来更像lambda
     */
    //public inline fun <T, R> with(receiver: T, block: T.() -> R): R
    fun alphabet3() = with(StringBuilder(), {
        for (letter in 'a'..'z') {
            println("--->" + letter)
        }
    });

    //标准写法
    fun alphabet3_1() = with(StringBuilder()) {

        for (letter in 'a'..'z') {
            println("===>" + letter)
        }

    }
            //测试用法run{}
            .run {
                println(" the end ")
            };

    alphabet3_1()
    //高阶函数 let、with、apply、run 总结
    //1) let 函数一般用于判断是否为空
    //let 函数的定义
    //public inline fun <T, R> T.let(block: (T) -> R): R {
    //    return block(this)
    //}
    //let 的使用
    var message: String? = "message"
    message?.let {
        //lambda参数it是message
        val result = it.substring(1)
        println(result)
    }
    //2) with 是全局函数，apply 是扩展函数，其他的都一样
    //3) run 函数的 lambda 是一个带有接受者的 lambda，而 let 不是，除此之外功能差不多
    //public inline fun <T, R> T.run(block: T.() -> R): R
    //public inline fun <T, R> T.let(block: (T) -> R): R
}
