package ObjectOriented

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
class Woman(name: String) : Human(name) {
    override fun sing() {

        println("sing loudly")
    }

    override fun eat() {

        println("Woman ${name}吃饭")
    }
}