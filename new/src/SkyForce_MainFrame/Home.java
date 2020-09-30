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

    public static JFrame frame;
    private static Game_Maintaining gamemaintainframe;
    private static Reader file;
    private static StringBuffer str;
    private static gameManager manager;
    private static Main_Class mainclass;
    private static StringBuilder stringbuilder;
    public ImageClass img;
    private SkyForce_Frame game;
    private Container c;

    /**
     * Create the application.
     */
    public Home() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home window = new Home();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(frame, "Are You want to leave?");
                if (option == JOptionPane.YES_OPTION) {
                    frame.dispose();
                } else if (option == JOptionPane.NO_OPTION) {

                }
            }
        });
//		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 11));
//		frame.getContentPane().setForeground(new Color(128, 0, 128));
        frame.setBackground(new Color(230, 230, 250));
        frame.setOpacity(1.0f);
        frame.setResizable(false);
        frame.setTitle("Airplane SkyForce");
        frame.setBounds(300, 200, gamemaintainframe.gameWidth, gamemaintainframe.gameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JButton btnNewButton = new JButton("Play");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setForeground(new Color(128, 0, 128));
        btnNewButton.setBackground(new Color(119, 136, 153));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamemaintainframe = new Game_Maintaining(" ", 500, 600);
                gamemaintainframe.start();
                frame.setVisible(false);

            }
        });
        btnNewButton.setBounds(131, 102, 147, 34);
        frame.getContentPane().add(btnNewButton);
        JButton btnNewButton_2 = new JButton("Last Score");
        btnNewButton_2.setBackground(new Color(112, 128, 144));
        btnNewButton_2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    file = new FileReader("C:\\Users\\IIT\\newscore.txt");
                    BufferedReader reader = new BufferedReader(file);
                    stringbuilder = new StringBuilder();
                    String line = null;

                    while ((line = (reader.readLine())) != null) {
                        stringbuilder.append(line);
                    }

                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                // Integer.parseInt(stringbuilder.toString());

                JOptionPane.showMessageDialog(frame, "Height Score is: " + Integer.parseInt(stringbuilder.toString()),
                        " SkyForce Score Board", JOptionPane.CLOSED_OPTION);

            }

        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_2.setForeground(new Color(139, 0, 139));
        btnNewButton_2.setBounds(131, 147, 147, 34);
        frame.getContentPane().add(btnNewButton_2);
//

        JButton help = new JButton("Help");
        help.setBackground(new Color(112, 128, 144));
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new HelpAbout();
            }
        });
        help.setForeground(new Color(128, 0, 0));
        help.setFont(new Font("Tahoma", Font.BOLD, 15));
        help.setBounds(131, 192, 147, 34);
        frame.getContentPane().add(help);

        //
        JButton btnNewButton_1 = new JButton("Exit");
        btnNewButton_1.setBackground(new Color(112, 128, 144));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        btnNewButton_1.setForeground(new Color(128, 0, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_1.setBounds(131, 240, 147, 34);
        frame.getContentPane().add(btnNewButton_1);
        frame.getContentPane().setFocusTraversalPolicy(
                new FocusTraversalOnArray(new Component[]{btnNewButton, btnNewButton_1, btnNewButton_2}));
        frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[]{help, btnNewButton_1, btnNewButton_2, frame.getContentPane(), btnNewButton}));
        frame.setVisible(true);
    }

}
