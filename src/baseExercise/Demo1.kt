package baseExercise

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

    println(map["好"] + map["好"] + map["学习"])
}

