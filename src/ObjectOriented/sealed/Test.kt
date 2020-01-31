package ObjectOriented.sealed

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
fun main(args: Array<String>) {
    var s1: Son = Son.小骡子()
    var s: Son = Son.小小驴()
    var s2: Son = Son.小骡子()
    var list = listOf<Son>(s, s2, s1)
    for (s in list) {
        if (s is Son.小骡子) {
            s.sayHello()
        }
    }
}