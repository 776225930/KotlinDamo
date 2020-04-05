package baseExercise

import java.lang.Math.PI
import java.math.BigInteger
import java.util.*

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
fun main(array: Array<String>) {
    var nums = 1..100;//[1 100]定义一个数组
    var result = 0;
    for (num in nums) {
        result = result + num;
    }
//    println("结果是${result}")
    var nums1 = 1 until 100 //[1,100)左闭右开
    for (num in nums1 step 2) {
//            println("->"+num)
    }
    var nums2 = nums1.reversed();//翻转
    //println("元素个数为" + nums2.count())
    for (num in nums2 step 2) {
//          println(num)
    }
//List
    var lists = listOf("包子", "面条", "披萨", "汉堡")
    for (list in lists) {
        println(list)
    }

    for ((i, e) in lists.withIndex()) {
        println("${i}--${e}")
    }
    val array = arrayOf("1", "2", "3");
//Map
    var map = TreeMap<String, String>();
    map["好"] = "Good"
    map["学习"] = "Study"
    map["天"] = "Day"
    map["向上"] = "Up"

//    println(map["好"] + map["好"] + map["学习"])


    //函数和函数式,区块体
    fun add(x: Int, y: Int): Int {
        return x + y;
    }

    //1.如果函数体只有一行,表达式体
    fun add1(x: Int, y: Int): Int = x + y

    //省略表达式返回值类型也是可以的
    fun add2(x: Int, y: Int) = x + y
//    println(add1(3,7))
    //2.把函数表达式赋给变量
    var i = { x: Int, y: Int -> x + y }
//    println(i(1, 7))
    //3.声明时指明类型
    var j: (x: Int, y: Int) -> Int = { x, y -> x + y }
//    println(j(2,4))


// 具名参数和默认参数

    val Pi = 3.14159f;
    //计算长方形面积
    fun getRectArea(width: Int, length: Int): Int {
        return width * length;
    }

    fun getCircleLength(PI: Float = Pi, radius: Float): Float {
        return 2 * PI * radius;
    }
//    println(getCircleLength(3.14f, 2f));
//    println(getCircleLength(radius = 3.14f, PI = 2f));
//    println(getCircleLength(radius = 2f));


//字符串和数字之间的转换

    var a = "13"
    var b = 13
    a = b.toString()
    b = a.toInt();

    var c = "a3"
//    b = c.toInt();//错误


//演示递归  阶乘

    fun fact(num: Int): Int {
        if (num == 1) {
            return 1;
        } else {
            return num * fact(num - 1)
        }
    }

    //    println(fact(5))
    //数字太大时用BigInteger
    fun fact1(num: BigInteger): BigInteger {
        if (num == BigInteger.ONE) {
            return BigInteger.ONE;
        } else {
            return num * fact1(num - BigInteger.ONE)
        }
    }

    var num = BigInteger("100");
//    println(fact1(num))

//尾递归优化

    //累加
    fun ollAdd(num: Int): Int {
        println("第${num}次运算")
        if (num == 0) {
            return 1
        } else {
            return num * ollAdd(num - 1)
        }
    }

    //        println(ollAdd(10000))//java.lang.StackOverflowError
    //尾递归优化后
    tailrec fun ollAdd1(num: Int, result: Int): Int {
        println("第${num}次运算,result=${result}")
        if (num == 0) {
            return 1
        } else {
            return ollAdd1(num - 1, result + num)
        }
    }

    var result1 = 0;
//    println(ollAdd1(10000, result1))

}



