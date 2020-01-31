package baseExercise

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe when 表达式
 */

fun main(args:Array<String>){
    gradeStudent(10)
}

fun gradeStudent(score: Int) {
    when (score) {
        10 -> println("考了满分，不错")
        9 -> println("优秀，不错")
        8 -> println("还可以，不错")
        7 -> println("加油，不错")
    }


}