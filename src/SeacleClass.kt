/**
 * @date   2018/12/9
 * @author JiangHao
 * @describe 印章类
 *          驴+马=骡子
 *          驴+驴=驴
 */
sealed class AnimalJr {
    class Donkey : AnimalJr()
    class Mule : AnimalJr()

    fun sayHello() {
        println("Hello !")
    }
}

fun main(args: Array<String>) {
    var donkey0: AnimalJr = AnimalJr.Donkey();
    var donkey1: AnimalJr = AnimalJr.Donkey();
    var mule0: AnimalJr = AnimalJr.Mule();
    var mule1: AnimalJr = AnimalJr.Mule();

    var list = listOf<AnimalJr>(donkey0,donkey1,mule0,mule1)
    for (v in list) {
        if (v is AnimalJr.Donkey) {
            v.sayHello()
        }
    }
}