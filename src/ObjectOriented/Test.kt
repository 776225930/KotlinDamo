package ObjectOriented

import javafx.scene.text.FontWeight
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
fun main(args: Array<String>) {

//图片处理
    //内存中创建一个宽和高为100的图片
    var image = BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)
    var w = 0..99
    var h = 0..99
    image.setRGB(50, 50, 0xff0000)
    image.apply {
        for (i in w) {
            for (j in h) {
                setRGB(i, j, 0x00ff00)
            }
        }
    }
    ImageIO.write(image, "bmp", File("b.bmp"))

    //高阶函数
    //不需要自己动手去写一个 JavaBean，可以直接使用 DataClass编译器会默默地帮我们生成以下函数
    data class Girl(var name: String, var age: Int, var height: Int, var weight: Int)

    var list = listOf<Girl>(
            Girl("Rose", 20, 160, 110),
            Girl("Lucy", 21, 162, 100),
            Girl("Nacy", 18, 165, 102),
            Girl("Joe", 19, 167, 108),
            Girl("Aria", 24, 169, 98),
            Girl("Marry", 28, 172, 110),
            Girl("Jane", 19, 156, 90),
            Girl("Jeans", 25, 162, 100),
            Girl("Kate", 21, 154, 91),
            Girl("Clare", 25, 172, 102),
            Girl("Clark", 26, 175, 106),
            Girl("XX", 33, 177, 110),
            Girl("YY", 32, 166, 100),
            Girl("ZZ", 31, 168, 106)
    )
    var someOne = ArrayList<Girl>()
    //传统条件赛筛选
    for (girl in list) {
        if (20 < girl.age && girl.age < 30) {
            someOne.add(girl)
        }
    }
    for (girl in someOne) {
        println("${girl.name}的年龄是 ${girl.age} 身高为 ${girl.height} 体重为 ${girl.weight}")
    }

//    println(list.maxBy { it.height })
//    println(list.minBy { it.height })
    //使用kotlin的filter进行条件筛选
//    println(list.filter {
//        (it.age > 20) and (it.height > 160)
//    })

    //map:把元素的某个属性映射成新的集合
    val result = list.map {
        "${it.name}:${it.height}"
    }
//    println(result)

    //any:是否有满足某个条件的元素
    println(list.any {
        it.age == 17
    })
    //count:统计满足条件的元素的个数
    println(list.count {
        it.age > 18
    })
    //find:查找符合条件的元素，返回第一个
    println(someOne.findLast {
        it.height > 160
    })
    //groupBy:按条件分组
    val groupBy = list.groupBy {
        it.height
//        it.height > 160
    }.get(170)?.forEach { println(it) }
//    println(groupBy)


//DSL

    //扩展函数  通配表达式
    infix fun List<Girl>.searchSomeOneWhichAgeBelow20(age: Int) {
        filter {
            it.age < age
        }.forEach(::println)
    }
    println("=======")
//    list.searchSomeOneWhichAgeBelow20(20)
    //使用统配表达式之后
    list searchSomeOneWhichAgeBelow20 20

}
