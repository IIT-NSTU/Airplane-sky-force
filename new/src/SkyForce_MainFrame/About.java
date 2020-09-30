package SkyForce_MainFrame;

import javax.swing.*;
import java.awt.*;

public class About {

    private JFrame frame;

    public About() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Created By");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel.setForeground(new Color(0, 100, 0));
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setBounds(83, 47, 137, 27);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Kamruzzaman Shekh");
        lblNewLabel_1.setForeground(new Color(139, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(137, 85, 213, 27);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Imran Hossain");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setForeground(new Color(139, 0, 139));
        lblNewLabel_2.setBounds(137, 124, 188, 27);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("SAJIB");
        lblNewLabel_3.setForeground(new Color(139, 0, 0));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_3.setBounds(137, 162, 137, 32);
        frame.getContentPane().add(lblNewLabel_3);
        frame.setVisible(true);
    }
}
