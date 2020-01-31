package ObjectOriented

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
class Boy(var character: String, var voice: String) {

    fun eat(): String {
        println("吃饭")
        return "吃饭"
    }

    fun play(): String {
        println("打球")
        return "吃饭"
    }

    //    fun code():String {
//        println("写代码")
//        return "吃饭"
//    }
    fun code(): String = "写代码"

}
