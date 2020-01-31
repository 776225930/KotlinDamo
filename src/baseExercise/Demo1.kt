package baseExercise

import java.lang.Math.PI
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
    //println("结果是${result}")
    var nums1 = 1 until 100 //[1,100)
    for (num in nums1 step 2) {
        //    println("->"+num)
    }
    var nums2 = nums1.reversed();//翻转
    //println("元素个数为" + nums2.count())
    for (num in nums2 step 2) {
        //  println(num)
    }
//List
    var lists = listOf("包子", "面条", "披萨", "汉堡")
    for (list in lists) {
//        println(list)
    }
    for ((i, e) in lists.withIndex()) {
//        println("${i}--${e}")
    }

//Map
    var map = TreeMap<String, String>();
    map["好"] = "Good"
    map["学习"] = "Study"
    map["天"] = "Day"
    map["向上"] = "Up"

//    println(map["好"] + map["好"] + map["学习"])


//函数和函数式

    fun add(x: Int, y: Int): Int {
        return x + y;
    }

    //1.如果函数体只有一行:
    fun add1(x: Int, y: Int): Int = x + y
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
    println(getCircleLength(3.14f, 2f));
    println(getCircleLength(radius = 3.14f, PI = 2f));
    println(getCircleLength(radius = 2f));


//字符串和数字之间的转换

    var a = "13"
    var b = 13
    a = b.toString()
    b = a.toInt();

    var c = "a3"
    b = c.toInt();//错误

}


