package lambda;


import java.util.Arrays;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 * @author JiangHao
 * @date 2020/2/2
 * @describe Lambda的使用前提
 * Lambda的语法非常简洁，完全没有面向对象复杂的束缚。但是使用时有几个问题需要特别注意：
 * 使用Lambda必须具有接口，且要求接口中有且仅有一个抽象方法。无论是JDK内置的Runnable 、Comparator 接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。
 * 使用Lambda必须具有上下文推断。也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。
 */
public class LambdaTest {

    public static void main(String[] args) {
//        System.out.println("hello world");
//        classicNewThread();
//        lambdaNewThread();
//        lambdaTest();
//        lambdaTest1();
        lambdaTest2();
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
     * lambda标准格式：(参数类型 参数名称) ‐> { 代码语句 }
     * 格式说明：
     * 小括号内的语法与传统方法参数列表一致：无参数则留空；多个参数则用逗号分隔。
     * -> 是新引入的语法格式，代表指向动作。
     * 大括号内的语法与传统方法体要求基本一致。
     * <p>
     * 函数式编程思想：
     * 只要能获取到结果，谁去做的，怎么做的都不重要，重要的是结果，不重视过程。
     */
    public static void lambdaNewThread() {
        //前面的一对小括号即run 方法的参数（无），代表不需要任何条件；
        //中间的一个箭头代表将前面的参数传递给后面的代码；
        //后面的输出语句即业务逻辑代码。
        new Thread(() -> System.out.println("Lambda多线程执行任务!")).start();
        new Thread(() -> {
            System.out.println("Lambda多线程执行任务!");
        }).start();
    }

    interface Cooker {
        void makeFooe();
    }

    public static void invokeCook(Cooker cooker) {
        //对于invokeCook方法的参数类型必须是接口，这里Cooker就是一个接口。
        //（备注：有且仅有一个抽象方法的接口，称为“函数式接口”。）
        cooker.makeFooe();
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

//使用Lambda标准格式（有参有返回）


    public interface Calculator {
        int calc(int a, int b);
    }

    public interface Sports {
        void play(String name);
    }

    public static void invokeSports(String name, Sports sports) {
        sports.play(name);
    }

    public static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }

    public static void lambdaTest2() {

//        invokeCalc(1, 2, (int a, int b) -> {
//            return a + b;
//        });
        //Lambda省略格式:可推导即可省略
        //小括号内参数的类型可以省略；
        // 如果小括号内有且仅有一个参，则小括号可以省略；
        // 如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。
//        invokeCalc(12, 13, (int a, int b) -> a + b);
        invokeCalc(12, 13, (a, b) -> a + b);
        invokeSports("篮球", name -> {
            System.out.println("打" + name);
        });
    }


}
