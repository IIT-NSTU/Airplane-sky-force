package SkyForce_MainFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageClass {

    public static BufferedImage image, bag1, bag2, bag3, bag4, bag5;
    public static BufferedImage CombineImg;
    public static BufferedImage player, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy11, enemy22, enemy33, enemy44, enemy55, enemy66;
    public static BufferedImage enemy = null;
    private static gameManager manager;

    public static void init() {
        // image=imageLoader("/background.jpg");
        CombineImg = imageLoader("/sky-airplane.png");

        //open enemies image
        enemy1 = imageLoader("/plane1.png");
        enemy2 = imageLoader("/plane2.png");
        enemy3 = imageLoader("/plane3.png");
        enemy4 = imageLoader("/plane4.png");
        enemy5 = imageLoader("/plane5.png");
        enemy6 = imageLoader("/plane6.png");

        //open background image
        bag1 = imageLoader("/background1.jpg");
        bag2 = imageLoader("/background2.jpg");
        bag3 = imageLoader("/background3.jpg");
        bag4 = imageLoader("/background4.jpg");
        bag5 = imageLoader("/background5.jpg");

        player = CombineImg.getSubimage(115, 0, 115, 95);
    }

    public static BufferedImage imageLoader(String path) {
        try {
            return ImageIO.read(ImageClass.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
