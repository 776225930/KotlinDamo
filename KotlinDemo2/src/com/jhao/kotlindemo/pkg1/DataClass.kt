package com.jhao.kotlindemo.pkg1

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe 新建 bean 类的时候，
 *           常常需要声明 equals、hashCode、toString 等方法，我们需要写很多代码。在 Kotlin 中，
 *           只需要在声明类的时候前面加 data 关键字就可以完成这些功能。
 *           节省了很多代码篇幅。需要注意的是，那么哪些属性参与 equals、hashCode、toString 方法呢？
 *             primary constructor 构造函数里的参数，都会参与 equals、hashCode、toString 方法里。
 * */

data class DataClass(var a: Int = 1) {

}