package com.jhao.kotlindemo.pkg1

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe Kotlin 新建内部类
 *           在 Kotlin 中内部类默认是静态的( Java 与此相反)，不持有外部类的引用
 */
class OutterClass {

    //在 Kotlin 中内部类默认是静态的，不持有外部类的引用
    class InnerStaticClass {}

    //如果要声明非静态的内部类，需要加上 inner 关键字
    inner class InnerClass {}
}