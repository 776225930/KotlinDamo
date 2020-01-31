package ObjectOriented

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
class WashMachine(var module: String, var size: Int) {

    var isDoorOpen = true
    private var curMode = 0;
    fun openDoor() {
        isDoorOpen = true
        println("打开洗衣机的门")
    }

    //    fun startWash() = println("开始洗衣服");
    fun startWash() {
        if (isDoorOpen) {
            println("洗衣服前请先关闭洗衣机的门")
        } else {
            when (curMode) {
                0 -> println("选择模式错误,不能开始洗衣服")
                1 -> {
                    println("选择模式为轻柔")
                    setMotorSpeed(100)
                    println("放水...")
                    println("开始洗衣服")
                }
                2 -> {
                    println("选择模式为甩干模式")
                    setMotorSpeed(600)
                    println("放水...")
                    println("开始洗衣服")
                }
                3 -> {
                    println("选择模式为漂洗模式")
                    setMotorSpeed(200)
                    println("放水...")
                    println("开始洗衣服")
                }
                else -> {
                    println("模式无法识别")
                }
            }
        }
    }

    fun closeDoor() {
        isDoorOpen = false
        println("关闭洗衣机的门")
    }

    fun select(mode: Int) {
        curMode = mode
        when (mode) {
            0 -> println("初始模式")
            1 -> println("轻柔模式")
            2 -> println("甩干模式")
            3 -> println("漂洗模式")
        }
    }

    fun setMotorSpeed(speed: Int) {
        println("当前发动机转速为 ${speed}圈/秒")
    }
}