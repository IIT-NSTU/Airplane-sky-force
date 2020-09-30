package SkyForce_MainFrame;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game_Maintaining implements Runnable {

    public static final int gameWidth = 400;
    public static final int gameHeight = 400;
    public SkyForce_Frame display;
    private String title;
    private int width;
    private int height;
    private Thread thread;
    private boolean running;
    private BufferStrategy buffer;
    private Graphics g;
    private int y;
    private boolean start;
    private gameManager manager;
    private BufferedImage image;

    public Game_Maintaining(String title, int width, int height) {

        this.title = title;
        this.width = width;
        this.height = height;

    }

    public void init() {
        display = new SkyForce_Frame(title, width, height);
        manager = new gameManager();
        manager.init();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }

    }

    public synchronized void stop() {
        if (!(running))
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        manager.tick();
    }

    public void render() {

        buffer = display.getCanvas().getBufferStrategy();
        if (buffer == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = buffer.getDrawGraphics();

        g.clearRect(0, 0, width, height);
        // draw
        // g.setColor(Color.GRAY);
        // g.fillRect(50, 50, gameWidth, gameHeight);
        Random ran = new Random();
        int b = ran.nextInt(5);
        if (manager.score <= 100) {
            image = ImageClass.bag1;
        } else if (manager.score > 100 && manager.score <= 200) {
            image = ImageClass.bag5;
        } else if (manager.score > 200 && manager.score <= 300) {
            image = ImageClass.bag3;
        } else if (manager.score > 300 && manager.score <= 400) {
            image = ImageClass.bag4;
        } else {
            image = ImageClass.bag2;
        }
        g.drawImage(image, 50, 50, gameWidth, gameHeight, null);
        manager.render(g);
        // menu

        // end of draw

        buffer.show();
        g.dispose();

    }

    public void run() {
        init();

        int fps = 50;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long current = System.nanoTime();

        while (running) {

            delta = delta + (System.nanoTime() - current) / timePerTick;
            current = System.nanoTime();
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }

        }
    }
}
