package ObjectOriented

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
class Rect(var height: Int, var width: Int)

fun main(args: Array<String>) {

    var rect = Rect(8, 24);
//    println("矩形的宽${rect.height},高${rect.width}")
    var boy: Boy = Boy("呵呵", "哈哈")
//    println("a boy ${boy.eat()},${boy.play()},${boy.code()}")
    var washMachine: WashMachine = WashMachine("小天鹅", 12)
//    washMachine.openDoor()
//    washMachine.closeDoor()
//    washMachine.select(2)
//    washMachine.startWash()

//    washMachine.setMotorSpeed(1000)

//    var son: Son = Son();
//    println("儿子：${son.character}")
//    son.action()

    var man: Man = Man("金三胖")
//    man.eat()
    var woman: Woman = Woman("慈禧")
//    woman.eat()

//    var person1 = Man("Jack");
//    var person2 = Man("Tony");
//    var person3 = Woman("Rose");
//    val humans = listOf<Human>(person1, person2, person3)
//    for (human in humans) {
//        human.sing()
//    }

//    var doge: Doge = Doge();
//    doge.run()

    var son = BigHeadSon
    var father = SmallHeadFather()
    son.washing()
    father.washing()


}

