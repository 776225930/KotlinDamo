package com.jhao.kotlindemo.pkg1

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe sealed class className
 *  sealed class 实际上是一个抽象类且不能被继承，构造方法是私有的。
 * 当我们使用 when 语句通常需要加 else 分支，如果添加了新的类型分支，
 * 忘记了在 when 语句里进行处理，遇到新分支，when 语句就会走 else 逻辑
 *  sealed class 就是用来解决这个问题的。如果有新的类型分支且没有处理编译器就会报错。
 */

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val value: Int) : Expr()
    class Minus(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
        when (e) {
            is Expr.Num -> e.value
            is Expr.Minus -> eval(e.left) + eval(e.right)
            is Expr.Sum -> e.value
        }
