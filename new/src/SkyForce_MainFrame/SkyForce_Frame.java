package SkyForce_MainFrame;

import javax.swing.*;
import java.awt.*;

public class SkyForce_Frame {

    public JFrame frame;
    private String title;
    private int width;
    private int height;
    private JButton cross_btn;
    private Canvas canvas;
    private Home h;
    private JButton pausebtn;

    public SkyForce_Frame(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    public void createDisplay() {
        frame = new JFrame(title);

        frame.setSize(width, height);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(28, 102, 221)));
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setBackground(new Color(14, 5, 3));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
