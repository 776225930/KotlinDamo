package com.jhao.kotlindemo.pkg1

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe 这种方法声明的类是一个单例类，以前在Java中新建一个单例类，需要写一些模板代码，
 *           在Kotlin中一行代码就可以了(类名前加上object关键字)
 */
object ObjectClass {

}

/**
 * companion object 为伴生对象，
 * 伴生体里面放的是一些静态成员：如静态常量、静态变量、静态方法
 */
class CompanionClass {
    //伴生对象
    //需要注意的是，在伴生体里面不同定义的方式有不同的效果，虽然他们都是静态的
    // companion object YourName{//默认生成的伴生体对象名字叫做 Companion,
    // 可以重命名为YourName
    companion object {
        //共有常量
        //1.如果使用 val 来定义，而没有使用 const 那么该属性是一个私有常量
        //2.如果使用 const 和 val 来定义则是一个公共常量
        const val FEMALE: Int = 0
        const val MALE: Int = 1

        //私有常量
        val GENDER: Int = FEMALE

        //私有静态变量
        //3.如果使用 var 来定义，则是一个静态变量
        var username: String = "Tom"

        //静态方法
        fun run() {
            println("run ...")
        }
    }
}

interface IAnimal {
    fun eat()
}

//除了给这个伴生对象起一个名字，还可以让其实现接口，如：
class ObjectKeyWordTest4 {
    //实现一个接口
    companion object : IAnimal {
        override fun eat() {
            println("伴生体 eat an apple")
        }
    }
}

fun feed(a: IAnimal) {
    a.eat()
}

fun main(args: Array<String>) {
    //把类名当作参数直接传递
    //实际传递的是静态对象 ObjectKeywordTest4.Companion
    //每个类只会有一个伴生对象
    feed(ObjectKeyWordTest4.Companion)
    feed(ObjectKeyWordTest4)
}
