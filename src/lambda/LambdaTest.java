package lambda;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 * @author JiangHao
 * @date 2020/2/2
 * @describe
 */
public class LambdaTest {

    public static void main(String[] args) {
//        System.out.println("hello world");
//        classicNewThread();
//        lambdaNewThread();
//        lambdaTest();
        lambdaTest1();
    }

    /**
     * 面向对象的思想：
     * 做一件事情，找一个能解决这个事情的对象，调用对象的方法，完成事情。
     */
    public static void classicNewThread() {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程执行任务!");
            }
        };
        //启动线程
        new Thread(task).start();
    }

    /**
     * 函数式编程思想：
     * 只要能获取到结果，谁去做的，怎么做的都不重要，重要的是结果，不重视过程。
     */
    public static void lambdaNewThread() {
        //前面的一对小括号即run 方法的参数（无），代表不需要任何条件；
        //中间的一个箭头代表将前面的参数传递给后面的代码；
        //后面的输出语句即业务逻辑代码。
        new Thread(() -> System.out.println("Lambda多线程执行任务!")).start();
    }

    interface Cook {
        void makeFooe();
    }

    public static void invokeCook(Cook cook) {
        cook.makeFooe();
    }

    public static void lambdaTest() {
//        小括号代表Cook 接口makeFood 抽象方法的参数为空，大括号代表makeFood 的方法体。
        invokeCook(() -> {
            System.out.println("吃饭啦！");
        });
    }

    public static void lambdaTest1() {
        // 本来年龄乱序的对象数组
        Person[] array = {
                new Person("古力娜扎", 19),
                new Person("迪丽热巴", 18),
                new Person("马尔扎哈", 20)
        };

        //传统写法:
        //匿名内部类
//        Comparator<Person> comparator = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        };
//        Arrays.sort(array, comparator);

        //使用lambda表达式:
        Arrays.sort(array, (Person a, Person b) -> {
            return a.getAge() - b.getAge();
        });
        for (Person p : array) {
            System.out.println(p);
        }
    }


}
