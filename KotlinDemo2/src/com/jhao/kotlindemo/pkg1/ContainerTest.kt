package com.jhao.kotlindemo.pkg1

/**
 * @date   2020/4/6
 * @author JiangHao
 * @describe Kotlin 中的集合底层也是使用 Java 集合框架那一套。在上层又封装了一层 可变集合 和 不可变集合 接口
 */
fun main(args: Array<String>) {
    //声明可变集合
    val mutableList = mutableListOf<String>("chiclim")//java.util.ArrayList
    val mutableSet = mutableSetOf<String>("Java")//java.util.LinkedHashList
    val mutableMap = mutableMapOf<String, String>("name" to "Tom")//java.util.LinkedHashList

    //输了使用mutableXXX声明可变集合,还可以通过下面的方法来声明具体的集合
    arrayListOf<String>("chiclim")//java.util.ArrayList

    hashSetOf<String>("Java")//java.util.hashSet
    linkedSetOf<String>("Java")//java.util.LinkedHashSet
    sortedSetOf<String>("Java")//java.util.TreeSet

    hashMapOf<String, String>("name" to "Tom")//java.util.HashMap
    linkedMapOf<String, String>("name" to "Tom")//java.util.LinkedHashMap
    sortedMapOf<String, String>("name" to "Tom")//java.util.TreeHashMap

    //声明不可变集合
    //在Kotlin中通过自定义了一套只读的集合接口:List、Set、Map,不会提供修改集合的方法
    //在编译后会转成Java的 List、Set、Map接口
    //java.util.Arrays$ArrayList
    val arrayList = listOf<String>("Java", "Kotlin", "Python")
    //java.util.LinkedHashSet
    val linkedHashSet = setOf<String>("Sun", "Moon", "Earth")
    //java.util.LinkedHashMap
    val linkedHashMap = mapOf<String, String>("name" to "Jerry")

    //Kotlin 集合常用的 API
    //1) all、any、count、find、firstOrNull、groupBy 函数
    val persons = listOf<Person>(Person("Rose", 20), Person("Tom", 12), Person("Jerry", 15), Person("Tonny", 18), Person("Mark", 20), Person("Kire", 21), Person("Jack", 22))
    val predicate = { p: Person ->
        p.age > 20
    }
    //是否所有人的年龄都大于20
    persons.all(predicate).apply {
        println(this)
    }
    //是否有一个人年龄大于20
    persons.any(predicate).apply {
        println(this)
    }
    //尽量少用！(下面两句是等价的,少用！避免增加理解难度)
    println("all " + !persons.all { person -> person.age == 27 })
    println("any " + persons.any { p -> p.age != 27 })

    //年龄大于20的人数
    persons.count().apply { println(this) }

    //获取第一个年龄大于20的人
    //find 等价于findNoNull
    persons.find(predicate).apply { println(this) }
    //按年龄分组
    persons.groupBy(Person::age).apply {
        println(this)
    }

    //2) filter、map、flatMap、flatten 函数
    val children = listOf<Child>(Child("Tom"), Child("Jerry"), Child("Luke"))
    val children1 = listOf<Child>(Child("Rose"), Child("Kobe"), Child("Ducan"))
    val people = listOf<Parents>(Parents(children), Parents(children1))
    println("map:")
    //map函数把每个parent的children集合放到新集合中,最终返回的记录是集合嵌套
    people.map(Parents::children).apply {
        println(this)
    }
    //flat是扁平的意思,flatMap把每个parent的每个child放到集合
    println("flatMap:")
    people.flatMap {
        it.children
    }.apply {
        println(this)
    }
    //也可以把集合通过嵌套flatten函数扁平化
    //
    println("flatten:")
    people.map(Parents::children).flatten().apply {
        println(this)
    }
    //年龄大于18的Person集合
    //发现调用 map 和 filter 分别创建了一个集合，也就是整个操作创建了两个 2 集合。
    val list = persons.map(Person::age).filter {
        it > 18
    }
    println(list)
    val list1 = persons.filter {
        it.age > 18
    }
    println(list1)

    //延迟集合操作之 Sequences
    //根据上面的分析，list.map(Person::age).filter { it > 18 } 会创建两个集合，
    //本来常规操作一个集合就够了，Sequence就是就是为了避免创建多余的集合的问题。
    //把filter函数放置在前面，可以有效减少map函数的调用次数
    val list2 = listOf<Person>(Person("Rose", 20), Person("Tom", 12), Person("Jerry", 15), Person("Tonny", 18), Person("Mark", 20), Person("Kire", 21), Person("Jack", 22))
    println()
    println("sequence")
    list2.asSequence().filter { person ->
        println("filter--->${person.name} : ${person.age}")
        person.age > 20
    }.map { person ->
        println("map--->${person.name} : ${person.age}")
        person.age
    }.forEach {
        println("---->符合条件的年龄 ： " + it)
    }
    list2.asSequence().filter { person ->
        println("-----")
        person.age > 20
    }.map { person ->
        println("=====")
        person.age
    }
    //filter--->Rose : 20
    //filter--->Tom : 12
    //filter--->Jerry : 15
    //filter--->Tonny : 18
    //filter--->Mark : 20
    //filter--->Kire : 21
    //map--->Kire : 21
    //---->符合条件的年龄 ： 21
    //filter--->Jack : 22
    //map--->Jack : 22
    //---->符合条件的年龄 ： 22

    //从这个输出日志我们可以总结出 Sequence 的原理：
    //集合的元素有序的经过 filte r操作，如果满足 filter 条件，再经过 map 操作。
    //而不会新建一个集合存放符合 filter 条件的元素，然后在创建一个集合存放 map 的元素
    //需要注意的是，如果集合的数量不是特别大，并不建议使用 Sequence 的方式来进行操作。
}

internal data class Person(var name: String, var age: Int) {}
internal data class Parents(var children: List<Child>) {}
internal data class Child(var name: String);