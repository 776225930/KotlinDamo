package ObjectOriented.sealed

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe  小公驴、小公马、小母驴
 *       印章类:Sealed class子类有限的class
 */
sealed class Son {

    fun sayHello() {
        println("大家好！")
    }

    class 小小驴() : Son()
    class 小骡子() : Son()

}