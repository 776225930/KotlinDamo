package baseExercise

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
fun main(args: Array<String>) {
    while (true) {
        println("请出入一个数字")
        val line1 = readLine()
        println("请出入第二个数字")
        val line2 = readLine()
        try {
            var num1: Int = line1!!.toInt()
            var num2: Int = line2!!.toInt()
            println("${num1}+${num2}=${num1 + num2}")
        } catch (e: Exception) {
//        e.printStackTrace()
            println("输入数据错误")
        }
    }

}