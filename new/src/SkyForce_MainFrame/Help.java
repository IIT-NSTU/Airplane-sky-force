package SkyForce_MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Help {

    private JFrame frame;

    public Help() {
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame();

        String[] instructions = {
                "Move Left = press Left Arrow",
                "Move Right = press Right Arrow",
                "Move down = press Down Arrow",
                "Move Up = press Up Arrow",
                "Shoot Bullet = press Space Key or B"
        };

        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        int componentPosX = 22;
        int componentPosY = 26;
        int componentWidth = 311;
        int componentHeight = 30;
        int componentSpace = 11;

        for (String str : instructions) {
            JLabel instructionLabel = new JLabel(str);
            instructionLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
            instructionLabel.setBounds(componentPosX, componentPosY, componentWidth, componentHeight);
            frame.getContentPane().add(instructionLabel);

            componentPosY += componentHeight + componentSpace;
        }

        frame.setVisible(true);
    }

    private class CloseWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            frame.dispose();
        }
    }
}
