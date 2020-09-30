package SkyForce_MainFrame;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class gameManager {
    public static ArrayList<Bullet> bullet;
    public static ArrayList<Enemy> enemy;
    public static int score = 0;
    public static int ex, ey;
    public static Game_Maintaining maintain;
    private static Bullet blt;
    private static int isupdate = 0;
    private static Main_Class mainclass;
    private static FileOutputStream file;
    private Player player;
    private Enemy eny;
    private long current_time;
    private long late;
    private SkyForce_Frame f;
    private Home home;
    private int strength;
    private int label = 2;

    public void init() {
        player = new Player((Game_Maintaining.gameWidth / 2) + 40, (Game_Maintaining.gameHeight - 50) + 50);
        player.init();
        bullet = new ArrayList<Bullet>();
        enemy = new ArrayList<Enemy>();
        current_time = System.nanoTime();
        late = 2000;
        strength = player.getStrength();
    }

    public void tick() {

        player.tick();
        for (int i = 0; i < bullet.size(); i++) {
            bullet.get(i).tick();
        }
        long wait = (System.nanoTime() - current_time) / 1000000;
        if (wait > late) {

            for (int i = 0; i < label; i++) {
                Random random = new Random();
                int x_ran = random.nextInt(450);
                int y_ran = random.nextInt(450);
                if (strength > 0) {

                    enemy.add(new Enemy(x_ran, -y_ran));

                }
            }
            current_time = System.nanoTime();
        }

        for (int i = 0; i < enemy.size(); i++) {
            enemy.get(i).tick();
        }
    }

    // starting render method
    public void render(Graphics g) {

        player.render(g);
        for (int i = 0; i < bullet.size(); i++) {
            if (bullet.get(i).getY() > 50) {
                bullet.get(i).render(g);
            } else {
                bullet.remove(bullet);
            }
        }
        for (int i = 0; i < enemy.size(); i++) {
            if (enemy.get(i).getX() >= 55 && enemy.get(i).getX() <= 450 - 33 && enemy.get(i).getY() >= 52
                    && enemy.get(i).getY() <= 450) {
                enemy.get(i).render(g);
            }

        }
        // bullet and enemy collision
        for (int e = 0; e < enemy.size(); e++) {
            int ex = enemy.get(e).getX();
            int ey = enemy.get(e).getY();
            this.ey = ey;
            for (int b = 0; b < bullet.size(); b++) {
                int bx = bullet.get(b).getX();
                int by = bullet.get(b).getY();

                // if(ex<bx+6 && ex+40>bx && ey<by+10 && ey+40>by)
                // if(ex<bx+6 && ex+40>bx && ey<by+10 && ey>by)
                if (ey >= 55 && ey <= 450) {
                    if (ex < bx + 10 && ex + 40 > bx && ey < by + 10 && ey + 44 > by) {
                        enemy.remove(e);
                        e--;
                        bullet.remove(b);
                        b--;
                        score += 5;
                    }
                }

            }

        }
        // player and enemy collision

        for (int e = 0; e < enemy.size(); e++) {
            int ex = enemy.get(e).getX();
            int ey = enemy.get(e).getY();

            int px = player.getX();
            int py = player.getY();

            if (px < ex + 40 && px + 60 > ex && py < ey + 40 && py + 60 > ey) {
//				enemy.removeAll(enemy);
//				f.frame.dispose();
//				home = new Home();
//				home.frame.setVisible(true);
                // finished();
                enemy.remove(e);
                strength--;
                if (strength <= 0) {
                    enemy.removeAll(enemy);
                    player.setStrength(0);

                    f.frame.dispose();
                    score = 0;
                    home = new Home();
                    home.frame.setVisible(true);
                    // maintain.stop();
                }

            }
        }
        g.setColor(Color.BLUE);
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.drawString("Score: " + score, 20, 550);
        g.drawString("Life: " + strength, 320, 550);
        g.setColor(Color.RED);
        g.drawLine(50, 495, 450, 495);
        if (score % 100 == 0 && score != 0) {
            g.setColor(Color.GREEN);
            g.drawString("Congratulation " + score, 160, 40);
        }
        if (score >= 0 && score <= 99) {
            label = 2;
            g.drawString("Level 1", 160, 40);
        } else if (score >= 100 && score <= 199) {
            try {
                for (Bullet b : bullet) {
                    b.setMotion(6);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            g.drawString("Level 2", 160, 40);
            label = 5;

        } else if (score >= 200 && score <= 500) {
            try {
                for (Bullet b : bullet) {
                    b.setMotion(8);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            g.drawString("Level 3", 160, 40);
            label = 7;
        } else if (score >= 501 && score <= 1000) {
            try {
                for (Bullet b : bullet) {
                    b.setMotion(10);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            g.drawString("Level 4", 160, 40);
            label = 11;
        }
        try {
            file = new FileOutputStream("C:\\Users\\IIT\\newscore.txt");

            String s = Integer.toString(score);
            byte[] b = s.getBytes();
            file.write(b);
            file.close();

        } catch (Exception e2) {
            // TODO: handle exception
        }

    }

    // end render method
}
