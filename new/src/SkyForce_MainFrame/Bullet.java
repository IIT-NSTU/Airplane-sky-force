package SkyForce_MainFrame;

import java.awt.*;
import java.util.Random;

public class Bullet {
    private int motion;
    private int posX;
    private int posY;

    public Bullet(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

        motion = 4;
    }

    public int getPositionX() {
        return posX;
    }

    public int getPositionY() {
        return posY;
    }

    public void setMotion(int gameLevel) {
        motion = gameLevel;
    }

    public void tick() {
        posY -= motion;
    }

    public void render(Graphics g) {
        Random random = new Random();
        int R = random.nextInt(255);
        int G = random.nextInt(255);
        int B = random.nextInt(255);
        g.setColor(new Color(R, G, B));
        g.fillRect(posX, posY, 6, 10);
    }
}
