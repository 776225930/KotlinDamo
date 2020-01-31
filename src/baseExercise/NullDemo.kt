package baseExercise

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
fun main(array: Array<String>) {
    println(heat("水"))
    heat(null);
}

//接收一个参数 参数是非空的Stirng类型,加上问号则表示参数可以为空
fun heat(str: String?): String {
    return "热" + str;
}