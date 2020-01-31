package ObjectOriented

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
class Rect(var height: Int, var width: Int)

fun main(args: Array<String>) {

    var rect = Rect(8, 24);
    println("矩形的宽${rect.height},高${rect.width}")
    var boy: Boy = Boy("呵呵", "哈哈")
    println("a boy ${boy.eat()},${boy.play()},${boy.code()}")
}