package baseExercise

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */

fun main(args: Array<String>): Unit {

    println(diaryGenerator("梧桐山"))
    checkGrade(50)
    var a = 2;
    var b = 5;
    println("${a}和${b}中较大的数是${judgeBig(a, b)}")
}

//日记生成器:接收地点参数,生成日记内容(测试字符串模板)
fun diaryGenerator(placeName: String): String {
    var temp = """今天天气晴朗，万里无云，我们去${placeName}游玩，首先引入眼帘的是${placeName}${placeName.length}个大字。"""
//    var temp = "今天天气晴朗，万里无云，我们去${placeName}游玩，首先引入眼帘的是${placeName}${baseExercise.number2String(placeName.length)}个大字。"

    return temp;
}

fun number2String(num: Int): String {
    var result = when (num) {
        1 -> "一"
        2 -> "二"
        3 -> "三"
        4 -> "四"
        5 -> "五"
        6 -> "六"
        7 -> "七"
        8 -> "八"
        9 -> "九"
        else -> "不知道"
    }
    return result;
}

fun checkGrade(grade: Int): Unit {
//    if (grade > 60) {
//        println("及格")
//    } else {
//        println("不及格")
//    }
    if (grade > 60) println("及格") else println("不及格")

}

fun judgeBig(a: Int, b: Int): Int {
    if (a > b) return a else return b
}
