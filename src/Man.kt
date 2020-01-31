/**
 * @date   2018/12/9
 * @author JiangHao
 * @describe
 */
class Man(name: String) : Human(name), IMan {
    override fun jump() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun eat() {
        TODO("not implemented")
        println("man ${name} eating");
    }
}