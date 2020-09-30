package SkyForce_MainFrame;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Home {

    public static final String lastScoreFilePath = "C:\\Users\\IIT\\newscore.txt";
    public static final int GameWidth = 400;
    public static final int GameHeight = 400;
    public static JFrame frame;

    public Home() {
        initializeGUI();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home window = new Home();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initializeGUI() {
        frame = new JFrame();
        JButton btnPlay = new JButton("Play");
        JButton btnLastScore = new JButton("Last Score");
        JButton btnHelp = new JButton("Help");
        JButton btnExit = new JButton("Exit");

        Component[] buttonList = {btnPlay, btnLastScore, btnHelp, btnExit};

        frame.addWindowListener(new CloseWindowAdapter());
        frame.getContentPane().setForeground(Color.BLACK);
        frame.setBackground(Color.WHITE);
        frame.setOpacity(1.0f);
        frame.setResizable(false);
        frame.setTitle("Airplane SkyForce");
        frame.setBounds(300, 200, GameWidth, GameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        btnPlay.addActionListener(new PlayActionListener());
        btnPlay.setForeground(Color.BLACK);
        btnPlay.setBounds(131, 102, 147, 34);

        btnLastScore.addActionListener(new ShowLastScoreActionListener());
        btnLastScore.setForeground(Color.DARK_GRAY);
        btnLastScore.setBounds(131, 147, 147, 34);

        btnHelp.addActionListener(new HelpActionListener());
        btnHelp.setForeground(Color.BLUE);
        btnHelp.setBounds(131, 192, 147, 34);

        btnExit.addActionListener(new ExitActionListener());
        btnExit.setForeground(Color.RED);
        btnExit.setBounds(131, 240, 147, 34);

        for (Component component : buttonList) {
            component.setFont(getTahomaBoldFont());
            component.setBackground(getButtonBackgroundColor());
            frame.getContentPane().add(component);
        }

        frame.setFocusTraversalPolicy(new FocusTraversalOnArray(buttonList));
        frame.setVisible(true);
    }

    private Color getButtonBackgroundColor() {
        return Color.LIGHT_GRAY;
    }

    private Font getTahomaBoldFont() {
        return new Font("Tahoma", Font.BOLD, 15);
    }

    private class PlayActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Game_Maintaining gameMaintainer = new Game_Maintaining("Airplane Skyforce", 500, 600);
            gameMaintainer.start();
            frame.setVisible(false);
        }
    }

    private class ShowLastScoreActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            StringBuilder fileContents = new StringBuilder();
            String line = null;

            try {
                FileReader fileReader = new FileReader(lastScoreFilePath);
                BufferedReader fileBufferReader = new BufferedReader(fileReader);

                while ((line = (fileBufferReader.readLine())) != null) {
                    fileContents.append(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(frame,
                    "Height Score is: " + Integer.parseInt(fileContents.toString()),
                    "SkyForce Score Board", JOptionPane.CLOSED_OPTION);
        }
    }

    private class HelpActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new HelpAbout();
        }
    }

    private class ExitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    private class CloseWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            int option = JOptionPane.showConfirmDialog(frame, "Do you want to leave?");
            if (option == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        }
    }
}
