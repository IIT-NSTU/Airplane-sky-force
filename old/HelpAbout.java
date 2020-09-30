package SkyForce_MainFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class HelpAbout {

	private JFrame frame;
	public HelpAbout() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(244, 164, 96));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Help");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(255, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help();
			}
		});
		btnNewButton.setBounds(161, 45, 124, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("About");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setBackground(new Color(255, 0, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new About();
			}
		});
		btnNewButton_1.setBounds(161, 115, 124, 48);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
	}
}
