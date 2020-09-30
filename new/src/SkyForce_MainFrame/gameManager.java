package SkyForce_MainFrame;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class gameManager {
    public static final String NewScoreSavePath = "C:\\Users\\IIT\\newscore.txt";
    public static int GameWidth = 500;
    public static int GameHeight = 500;

    public static ArrayList<Bullet> bulletList;
    public static ArrayList<Enemy> enemyList;
    
    public static int score = 0;
    public static int ex, ey;
    public static Game_Maintaining maintain;
    private static Bullet blt;
    private static int isupdate = 0;
    private static Main_Class mainclass;
    private static FileOutputStream file;
    private Player player;
    private Enemy eny;
    private long currentTime;
    private long late;
    private SkyForce_Frame f;
    private Home home;
    private int playerStrength;
    private int level = 2;

    public void init() {
        int playerPosX = (GameWidth / 2) + 40;
        int playerPosY = (GameHeight - 50) + 50;
        
        player = new Player(playerPosX, playerPosY);
        bulletList = new ArrayList<Bullet>();
        enemyList = new ArrayList<Enemy>();
        player.init();
        currentTime = System.nanoTime();
        late = 2000;
        playerStrength = player.getStrength();
    }

    public void tick() {
        player.tick();
        for (int i = 0; i < bulletList.size(); i++) 
            bulletList.get(i).tick();

        generateRandomEnemy();

        for (int i = 0; i < enemyList.size(); i++)
            enemyList.get(i).tick();
    }

    public void render(Graphics g) {
        player.render(g);

        renderBulletList(g);
        renderEnemyList(g);

        bulletDestroyingEnemy();
        playerEnemyCollision();

        g.setColor(Color.BLUE);
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.drawString("Score: " + score, 20, 550);
        g.drawString("Life: " + playerStrength, 320, 550);
        g.setColor(Color.RED);
        g.drawLine(50, 495, 450, 495);

        if (score % 100 == 0 && score != 0) {
            g.setColor(Color.GREEN);
            g.drawString("Congratulation " + score, 160, 40);
        }

        if (score >= 0 && score <= 99) {
            level = 2;
            g.drawString("Level 1", 160, 40);
        } else if (score >= 100 && score <= 199) {
            try {
                for (Bullet b : bulletList)
                    b.setMotion(6);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            g.drawString("Level 2", 160, 40);
            level = 5;
        } else if (score >= 200 && score <= 500) {
            try {
                for (Bullet b : bulletList)
                    b.setMotion(8);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            g.drawString("Level 3", 160, 40);
            level = 7;
        } else if (score >= 501 && score <= 1000) {
            try {
                for (Bullet b : bulletList)
                    b.setMotion(10);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            g.drawString("Level 4", 160, 40);
            level = 11;
        }

        saveScore();
    }

    private void generateRandomEnemy() {
        long wait = (System.nanoTime() - currentTime) / 1000000;
        if (wait > late) {
            for (int i = 0; i < level; i++) {
                Random random = new Random();
                int randomX = random.nextInt(450);
                int randomY = random.nextInt(450);
                if (playerStrength > 0)
                    enemyList.add(new Enemy(randomX, -randomY));
            }
            currentTime = System.nanoTime();
        }
    }

    private void renderBulletList(Graphics g) {
        for (Bullet bullet : bulletList) {
            if (bullet.getPositionY() > 50)
                bullet.render(g);
            else
                bulletList.clear();
        }
    }

    private void renderEnemyList(Graphics g) {
        for (int i = 0; i < enemyList.size(); i++) {
            if (enemyList.get(i).getX() >= 55 &&
                    enemyList.get(i).getX() <= 450 - 33 &&
                    enemyList.get(i).getY() >= 52 &&
                    enemyList.get(i).getY() <= 450) {
                enemyList.get(i).render(g);
            }
        }
    }

    private void bulletDestroyingEnemy() {
        for (Enemy enemy : enemyList) {
            int enemyPosX = enemy.getX();
            int enemyPosY = enemy.getY();

            this.ey = enemyPosY;

            for (Bullet bullet : bulletList) {
                int bulletPosX = bullet.getPositionX();
                int bulletPoxY = bullet.getPositionY();

                if (enemyPosY >= 55 && enemyPosY <= 450) {
                    if (enemyPosX < (bulletPosX + 10)
                            && (enemyPosX + 40) > bulletPosX
                            && enemyPosY < (bulletPoxY + 10)
                            && (enemyPosY + 44) > bulletPoxY) {
                        // Removing imediately from the list can cause exception
                        enemyList.remove(enemy);
                        bulletList.remove(bullet);
                        score += 5;
                    }
                }
            }
        }
    }

    private void playerEnemyCollision() {
        for (Enemy enemy : enemyList) {
            int enemyPosX = enemy.getX();
            int enemyPosY = enemy.getY();

            int playerPosX = player.getX();
            int playerPosY = player.getY();

            if (playerPosX < (enemyPosX + 40)
                    && (playerPosX + 60) > enemyPosX
                    && playerPosY < (enemyPosY + 40)
                    && (playerPosY + 60) > enemyPosY) {
                enemyList.remove(enemy);
                playerStrength--;
                if (playerStrength <= 0) {
                    enemyList.removeAll(enemyList);
                    player.setStrength(0);
                    score = 0;

                    f.frame.dispose();
                    Home home = new Home();
                }
            }
        }
    }

    private void saveScore() {
        try {
            FileOutputStream file = new FileOutputStream(NewScoreSavePath);
            String s = Integer.toString(score);
            byte[] b = s.getBytes();
            file.write(b);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
