package com.deepsingh44.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.deepsingh44.util.Utility;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFile frame = new LoginFile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public LoginFile() {
		
		setResizable(false);
		setTitle("Login Detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 425);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(39, 59, 220, 274);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel(" ");
		label.setIcon(Utility.resize(new ImageIcon(LoginFile.class.getResource("/com/deepsingh44/images/login_logo.jpg")), 162, 130));
		label.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		label.setBounds(29, 11, 162, 130);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("<html><p>A login is a set of credentials used to authenticate a user. Most often, these consist of a username and password. ... Logins are used by websites, computer applications, and mobile apps.</p><html>",JLabel.CENTER);
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Serif", Font.PLAIN, 12));
		label_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		label_1.setBounds(10, 152, 200, 111);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		//panel_2.setBackground(new Color(51, 102, 102));
		panel_2.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(295, 59, 267, 274);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLoginDetails = new JLabel("Login Details",JLabel.CENTER);
		lblLoginDetails.setForeground(new Color(255, 255, 255));
		lblLoginDetails.setFont(new Font("Serif", Font.BOLD, 14));
		lblLoginDetails.setBounds(62, 11, 152, 25);
		panel_2.add(lblLoginDetails);
		
		textField = new JTextField();
		textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField.setBounds(24, 88, 220, 30);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterEmailId = new JLabel("Enter Email Id");
		lblEnterEmailId.setForeground(new Color(255, 255, 255));
		lblEnterEmailId.setFont(new Font("Serif", Font.PLAIN, 11));
		lblEnterEmailId.setBounds(24, 70, 127, 14);
		panel_2.add(lblEnterEmailId);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setForeground(new Color(255, 255, 255));
		lblEnterPassword.setFont(new Font("Serif", Font.PLAIN, 11));
		lblEnterPassword.setBounds(24, 126, 127, 14);
		panel_2.add(lblEnterPassword);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_1.setColumns(10);
		textField_1.setBounds(24, 144, 220, 30);
		panel_2.add(textField_1);
		
		JButton btnNewButton = new JButton("Login Here");
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(51, 153, 153));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(24, 196, 220, 30);
		panel_2.add(btnNewButton);
		
		JLabel lblForSignupClick = new JLabel("For SignUp click Here",JLabel.RIGHT);
		lblForSignupClick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			new RegisterFile().setVisible(true);
			dispose();
			}
		});
		lblForSignupClick.setFont(new Font("Serif", Font.BOLD, 12));
		lblForSignupClick.setForeground(new Color(255, 255, 255));
		lblForSignupClick.setBounds(107, 237, 137, 17);
		panel_2.add(lblForSignupClick);
		
		JLabel label_2 = new JLabel(" ");
		label_2.setIcon(Utility.resize(new ImageIcon(LoginFile.class.getResource("/com/deepsingh44/images/background.jpg")), 593, 376));
		label_2.setBounds(0, 0, 593, 376);
		panel.add(label_2);
	}
}
