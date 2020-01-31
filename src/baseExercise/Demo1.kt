package baseExercise

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
    println("结果是${result}")
    var nums1 = 1 until 100 //[1,100)
    for (num in nums1 step 2) {
        println("->"+num)
    }
    var nums2 = nums1.reversed();//翻转
    println("元素个数为" + nums2.count())
    for (num in nums2 step 2) {
        println(num)
    }

}

