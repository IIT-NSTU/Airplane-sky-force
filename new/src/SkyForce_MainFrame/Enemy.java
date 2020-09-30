package SkyForce_MainFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public static BufferedImage enemy = null;

    private int posX;
    private int posY;

    public Enemy(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public void setY(int val) {
        this.posY = val;
    }

    public void tick() {
        posY += 1;
    }

    public void render(Graphics g) {
        if (posY >= 50 && posY <= 93) enemy = ImageClass.enemy1;
        else if (posY >= 94 && posY <= 137) enemy = ImageClass.enemy6;
        else if (posY >= 138 && posY <= 181) enemy = ImageClass.enemy3;
        else if (posY >= 182 && posY <= 225) enemy = ImageClass.enemy4;
        else if (posY >= 226 && posY <= 313) enemy = ImageClass.enemy5;
        else enemy = ImageClass.enemy2;

        g.drawImage(enemy, posX, posY, 40, 44, null);

    }
}

	


