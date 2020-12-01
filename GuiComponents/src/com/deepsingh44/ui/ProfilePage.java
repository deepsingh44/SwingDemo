package com.deepsingh44.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProfilePage extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ProfilePage() {
		setTitle("Profile Page");
		setClosable(true);
		setIconifiable(true);
		setBounds(50, 15, 570, 408);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBounds(201, 34, 128, 99);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(66, 179, 190, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(new Color(255, 255, 255));
		lblFullName.setBounds(66, 161, 69, 14);
		panel.add(lblFullName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(291, 179, 190, 30);
		panel.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(291, 161, 46, 14);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 238, 190, 30);
		panel.add(textField_2);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(66, 220, 69, 14);
		panel.add(lblPassword);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(291, 238, 190, 30);
		panel.add(textField_3);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setForeground(Color.WHITE);
		lblMobile.setBounds(291, 220, 46, 14);
		panel.add(lblMobile);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 294, 279, 30);
		panel.add(textField_4);
		
		JLabel lblProfileImage = new JLabel("Profile Image");
		lblProfileImage.setForeground(Color.WHITE);
		lblProfileImage.setBounds(66, 276, 96, 14);
		panel.add(lblProfileImage);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.setBounds(355, 294, 122, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Profile");
		btnNewButton_1.setBounds(184, 340, 153, 30);
		panel.add(btnNewButton_1);

	}
}
