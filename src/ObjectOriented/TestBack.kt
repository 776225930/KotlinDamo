package ObjectOriented

import java.io.BufferedReader
import java.util.*

/**
 * @date   2020/4/5
 * @author JiangHao
 * @describe
 */
fun main(args: Array<String>): Unit {

    val map = mapOf("a" to "1");
    var map1 = HashMap<String, String>();
    map1["a"] = "1";
    map1["b"] = "2";
    println(map1)
    var a = 1
    var b = 0
    var max = if (a > b) a else b;

    var num = try {
//        1 / 0;
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {

    }

    fun readNumber(reader: BufferedReader): Int {
        reader.use {
            val line = reader.readLine();
            return Integer.parseInt(line);
        }
    }

    println(num);
//    testIs("呵呵呵呵")
    //for
    for (i in 1..100) {
//        println(i)
    }
    for (i in 100 downTo 0 step 2) {
        println(i)
    }

    /**
     * 扩展函数是在类的外部定义，但是可以像类成员一样调用该函数
     * String叫做receiver type就是我们扩展的目标类 ,
     * this 叫做 receiver object 就是目标类的对象(哪个对象调用该扩展函数，这个this就是哪个对象,此处为String的对象)
     * 作用:相当于扩展了String类的功能，增加了一个lastChar方法
     * 扩展函数本质上是静态函数
     */
    fun String.lastChar(): Char = this.get(this.length - 1)

    fun String.lastChar1(): Char = this.get(this.length - 1)
    var str = "abcdefs"
    println(str.lastChar1())
    //扩展属性
    println(str.lastChar)
    println(str.lastChar1)

    /**
     * 展开操作符 *
     * 不使用 展开操作符 asLis会直接把整个函数当成Object对象
     */
    val intArray: Array<Int> = arrayOf(1, 2, 3, 4, 5)

    println(Arrays.asList(0, intArray))//[0, [Ljava.lang.Integer;@5caf905d]
    println(Arrays.asList(0, 3, *intArray))//[0, 1, 2, 3, 4, 5]

    /**
     *  中缀调用
    我们都知道什么是前缀(prefix)，后缀(suffix)。那什么是函数的中缀(infix)调用呢？
    使用关键字 infix 修饰的函数都能够 中缀调用
    被关键字 infix 修饰的函数只能有一个参数
    Kotlin 中的 to 就是一个中缀函数：
     */
    val to = 1 to "one"
    println(to);
    val to1 = 1.to("two")
    println(to1.javaClass);
    println(to1);
}


/**
 * 类型判断 is
 */
fun testIs(obj: Any) {

    //
    if (obj is String) {
        //进入括号中 已经自动转换为String类型
        println(obj.javaClass)
        println(obj.length / 2)
    }
    //出了括号恢复原来类型
    println(obj.javaClass)
}

/**
 * 枚举类的使用
 */
enum class Color(val r: Int, val g: Int, val b: Int) { //枚举长两属性
    //定义枚举常量对象
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}

/**
 * 扩展属性(必须在类中)
 * 必须为这个扩展属性定义 getter 函数，因为扩展属性没有 backing field
 * 扩展属性在定义的时候，也会生成静态方法：
 */
val String.lastChar: Char get() = this.get(length - 1)
val String.lastChar1: Char get() = 'g'

/**
 *  可变参数
 *  java 中使用 ... 表示
 *  kotlin 中使用 vararg表示
 *   * 展开操作符
 *  不使用 * 转化的java代码 printlnMsg((Object)value);
 *  使用 * 后转化的java代码 printlnMsg(Arrays.copyOf(value, value.length));
 */
fun <T> listOf(vararg items: T): List<T> {
    println(items.javaClass)//数组类型
    return Arrays.asList<T>(*items);//* spread operator
}

