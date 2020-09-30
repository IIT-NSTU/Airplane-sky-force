package SkyForce_MainFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
    private static SkyForce_Frame display;
    private static int strength;
    private int posX;
    private int posY;
    private boolean left, right;
    private boolean up, down;
    private boolean attack;
    private gameManager manager;
    private long present;
    private long late;

    public Player(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public void init() {
        present = System.nanoTime();
        late = 100;
        strength = 2;
        display.frame.addKeyListener(this);
        ImageClass.init();
    }

    public void tick() {
        if (strength <= 0)
            return;

        if (left && posX > 50)
            posX = posX - 5;

        if (right && posX < Game_Maintaining.gameWidth - 5)
            posX = posX + 3;

        if (up && posY > 50)
            posY = posY - 3;

        if (down && posY < 393)
            posY += 5;

        if (attack) {
            long wait = (System.nanoTime() - present) / 1000000;
            if (wait > late) {

                manager.bulletList.add(new Bullet(posX + 25, posY));
            }
            present = System.nanoTime();
        }
    }

    public void render(Graphics g) {
        if (!(strength <= 0))
            g.drawImage(ImageClass.player, posX, posY - 5, 60, 60, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) left = true;
        if (key == KeyEvent.VK_RIGHT) right = true;
        if (key == KeyEvent.VK_B) attack = true;
        if (key == KeyEvent.VK_SPACE) attack = true;
        if (key == KeyEvent.VK_UP) up = true;
        if (key == KeyEvent.VK_DOWN) down = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) left = false;
        if (key == KeyEvent.VK_RIGHT) right = false;
        if (key == KeyEvent.VK_B) attack = false;
        if (key == KeyEvent.VK_SPACE) attack = false;
        if (key == KeyEvent.VK_UP) up = false;
        if (key == KeyEvent.VK_DOWN) down = false;
    }

    public void keyTyped(KeyEvent arg0) {
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
