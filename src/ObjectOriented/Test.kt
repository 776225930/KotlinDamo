package ObjectOriented

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @date   2020/1/31
 * @author JiangHao
 * @describe
 */
fun main(args: Array<String>) {
    //内存中创建一个宽和高为100的图片
    var image = BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)
    var w = 0..99
    var h = 0..99
    image.setRGB(50, 50, 0xff0000)
    image.apply {
        for (i in w) {
            for (j in h) {
                setRGB(i, j, 0x00ff00)
            }
        }
    }
    ImageIO.write(image, "bmp", File("b.bmp"))
}