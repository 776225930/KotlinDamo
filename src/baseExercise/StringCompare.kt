package baseExercise

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
fun main(array: Array<String>) {
    var str1 = "Andy"
    var str2 = "andy"

    println(str1 == str2)//区分大小写
    println(str1.equals(str2))//区分大小写

    println(str1.equals(str2,true));//忽略大小写
}