package baseExercise

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
//日记生成器:接收地点参数,生成日记内容(测试字符串模板)
fun diaryGenerator(placeName: String): String {
    var temp = """今天天气晴朗，万里无云，我们去placeName游玩，首先引入眼帘的是中三公园四个大字。"""

    return temp;
}

fun main(args: Array<String>): Unit {

    println(diaryGenerator("梧桐山"))
}