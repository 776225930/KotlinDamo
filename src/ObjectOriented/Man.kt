package ObjectOriented

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
class Man(name: String) : Human(name) {
    override fun eat() {
        println("Man ${name}吃饭")
    }

}