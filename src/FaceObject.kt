/**
 * @date   2018/12/9
 * @author JiangHao
 * @describe
 */
class Rect(var height: Int, var width: Int)

fun main(args: Array<String>) {
    var rect = Rect(20, 30)
    println("矩形的宽度:${rect.width}");
    println("矩形的高度:${rect.height}")
    var girl=Girl("beauutiful","sweet")
    girl.sayHello()
    girl.smile();
}

class Girl(var character: String, var voice: String) {

    fun smile() {
        println("微笑")
    }

    fun sayHello() {
        println("你好!")
    }

    fun sing() {
        println("唱歌")
    }

}