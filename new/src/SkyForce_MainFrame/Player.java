package SkyForce_MainFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
    private static SkyForce_Frame display;
    private static int strength;
    private int x;
    private int y;
    private boolean left, right;
    private boolean up, down;
    private boolean attack;
    private gameManager manager;
    private long present;
    private long late;

    public Player(int x_point, int y_point) {
        this.x = x_point;
        this.y = y_point;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void init() {
        present = System.nanoTime();
        late = 100;
        strength = 2;
        display.frame.addKeyListener(this);
        ImageClass.init();

    }

    public void tick() {
        if (!(strength <= 0)) {
            if (left) {
                if (x > 50) {
                    x = x - 5;
                }
            }

            if (right) {
                if (x < Game_Maintaining.gameWidth - 5) {
                    x = x + 3;
                }
            }
            if (up) {
                if (y > 50) {
                    y = y - 3;
                }
            }
            if (down) {
                if (y < 393) {
                    y += 5;
                }
            }
            if (attack) {
                long wait = (System.nanoTime() - present) / 1000000;
                if (wait > late) {
                    manager.bullet.add(new Bullet(x + 25, y));
                }
                present = System.nanoTime();
            }
        }
    }
    //}

    public void render(Graphics g) {
        if (!(strength <= 0)) {
            //g.drawImage(ImageClass.player,x, y, 50, 50, null);
            g.drawImage(ImageClass.player, x, y - 5, 60, 60, null);
            //}
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (key == KeyEvent.VK_B) {
            attack = true;
        }
        if (key == KeyEvent.VK_SPACE) {
            attack = true;
        }
        if (key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (key == KeyEvent.VK_B) {
            attack = false;
        }
        if (key == KeyEvent.VK_SPACE) {
            attack = false;
        }
        if (key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int s) {
        this.strength = s;
    }


}
