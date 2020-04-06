package com.jhao.kotlindemo.pkg1

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe
 */
//internal open class Parent() {//primary constructor
internal open class Parent {

    internal var a: Int = 0
    var name: String? = null

    //secondary constructor
    constructor() {}
    constructor(name: String) {
        this.name = name
    }

    //    init 代码块 的执行时机是构造函数被调用的时候，编译器会把 init 代码块里的代码 copy 到构造函数里。
    init {

    }
}

internal class a : Parent() {
    var par: Parent = Parent()
    fun test() {
        a;
    }
}