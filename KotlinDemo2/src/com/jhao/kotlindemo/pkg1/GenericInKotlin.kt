package com.jhao.kotlindemo.pkg1

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe
 */


//定义一个`盘子`类
class Bowel<T>(private var item: T?) {

    fun set(t: T) {
        item = t
    }

    fun get(): T? {
        return item
    }

}

internal class Pear : Fruit() {}

fun main(args: Array<String>) {


    //关于泛型的不变性，Kotlin 和 Java都是一致的。比如 List<Apple> 不能赋值给 List<Fruit>
    fun takeFruitInvariance(fruit: List<Fruit>) {

    }
    //1) Kotlin 协变
    val apples: List<Apple> = listOf(Apple(), Apple())
    //编译器不会报错，为什么可以把 List<Apple> 赋值给 List<Fruit>，
    //根据泛型不变性 ，应该会报错的。
    //不报错的原因是这里的 List 不是 java.util.List 而是 Kotlin 里的 List：
    ////kotlin Collection：
    //public interface List<out E> : Collection<E>
    ////Java Collection：
    //public interface List<E> extends Collection<E>
    //发现 Kotlin 的 List 泛型多了 out 关键字，
    //这里的 out 关键相当于 java 的 extends 通配符
    takeFruitInvariance(apples)
    //所以不仅可以把 List<Apple> 赋值给 List<Fruit>，Fruit 的子类都可以：
    val pears = listOf<Pear>(Pear(), Pear())
    takeFruitInvariance(pears)

    //2) Kotlin 逆变
    //out关键字对应Java中的extends关键字，
    //那么Java的super关键字对应Kotlin的in关键字
    //关于逆变 Kotlin 中的排序函数 sortedWith，就用到了 in 关键字：
    //public fun <T> Iterable<T>.sortedWith(comparator: Comparator<in T>): List<T>
    //声明3个比较器
    val foodComparator = Comparator<Food> { a1, a2 ->
        a1.hashCode() - a2.hashCode()
    }
    val fruitComparator = Comparator<Fruit> { a1, a2 ->
        a1.hashCode() - a2.hashCode()
    }
    val appleComparator = Comparator<Apple> { a1, a2 ->
        a1.hashCode() - a2.hashCode()
    }
    //声明一个集合
    val list = listOf(Fruit(), Fruit(), Fruit(), Fruit(), Fruit())
    //Comparator声明成了逆变 (contravariant)，这和 Java 的泛型通配符 super 一样的
    //所以只能传递 Fruit 以及 Fruit 父类的 Comparator
    list.sortedWith(foodComparator)
    list.sortedWith(fruitComparator)
    //list.sortedWith(appleComparator)//编译报错

    //3) Kotlin和Java在协变性、逆变性的异同点
    //Java 中的上界通配符 extends 和下界通配符 super，这两个关键字非常形象
    //extends 表示 只要 继承 了这个类包括其本身都能存放
    //super 表示 只要是这个类的父类包括其本身都能存放
    //同样的 Kotlin 中 out 和 in 关键字也很相像，这个怎么说呢？
    //在介绍 Java 泛型的时候说过，上界通配符 extends 只能 get (后者只能做出参，这就是 out)，不能 set (意思就是不能参数传进来)。所以只能出参(out)
    //下界通配符 super 只能 set (意思就是可以入参，这就是 in)，不能 get。所以只能入参(in)
    //Kotlin 和 Java 只是站在不同的角度来看这个问题而已。可能 Kotlin 的 in 和 out 更加简单明了，不用再记什么 PECS(Producer Extends, Consumer Super) 缩写了
    //除了关键字不一样，另一方面，Java 和 Kotlin关于泛型定义的地方也不一样。
    //在介绍 Java 泛型的时候，我们定义通配符的时候都是在方法上，比如：
    //void takeExtendsFruit(Plate<? extends Fruit> plate)

    //虽然Java支持在类上使用 ? extends Type，但是不支持 ? super Type，并且在类上定义了 ? extends Type，对该类的方法是起不到 只读、只写 约束作用的。
    //我们把 Java 上的泛型变异称之为：use-site variance，意思就是在用到的地方定义变异
    //在 Kotlin 中，不仅支持在用到的地方定义变异，还支持在定义类的时候声明泛型变异 (declaration-site variance)
    //比如上面的排序方法 sortedWith 就是一个 use-site variance：
    //public fun <T> Iterable<T>.sortedWith(comparator: Comparator<in T>): List<T>
    //再比如 Kotlin List，它就是 declaration-site variance，它在声明List类的时候，定义了泛型协变
    //这个时候会对该 List 类的方法产生约束：泛型不能当做方法入参，只能当做出参。
    // Kotlin List 源码片段如下所示：
    //public interface List<out E> : Collection<E> {
    //
    //    public operator fun get(index: Int): E
    //
    //    public fun listIterator(): ListIterator<E>
    //
    //    public fun listIterator(index: Int): ListIterator<E>
    //
    //    public fun subList(fromIndex: Int, toIndex: Int): List<E>
    //
    //    public fun indexOf(element: @UnsafeVariance E): Int
    //
    //    //省略其他代码
    //}
    //比如 get、subList 等方法泛型都是作为出参返回值的，我们也发现 indexOf 方法的参数竟然是泛型 E，不是说只能当做出参，不能是入参吗？
    //这里只是为了兼容 Java 的 List 的 API，所以加上了注解 @UnsafeVariance (不安全的协变)，编译器就不会报错了。
    //例如我们自己定义一个 MyList 接口，不加 @UnsafeVariance 编译器就会报错了：

    //4).Kotlin 泛型擦除和具体化
    //Kotlin 和 Java 的泛型只在编译时有效，运行时会被擦除 (type erasure)
    //在泛型类被类型擦除的时候，如果类型参数部分没有指定上限，
    //如 <T> 会被转译成普通的 Object 类型，如果指定了上限，则类型参数被替换成类型上限。
    //Error: Cannot check for instance of erased type: T
    //fun <T> isType(value:Any)=value is T

    //Kotlin 提供了一种泛型具体化的技术，它的原理是这样的：
    //
    //我们知道泛型在运行时会擦除，但是在 inline 函数中我们可以指定泛型不被擦除，
    //因为 inline 函数在编译期会 copy 到调用它的方法里，所以编译器会知道当前的方法中泛型对应的具体类型是什么，
    //然后把泛型替换为具体类型，从而达到不被擦除的目的，在 inline 函数中我们可以通过 reified 关键字来标记这个泛型在编译时替换成具体类型
    //如下面的代码就不会报错了：
    //inline fun <reified T> isType(value: Any) = value is T

}

