package com.deepsingh44.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.deepsingh44.util.Utility;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class UpdateExpense extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public UpdateExpense() {
		setTitle("Update Expense");
		setClosable(true);
		setIconifiable(true);
		setBounds(50, 15, 570, 408);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 102, 102));
		panel_1.setBounds(0, 0, 554, 378);
		panel.add(panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UpdateExpense.class.getResource("/com/deepsingh44/images/background.jpg")));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBounds(201, 34, 128, 99);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(66, 179, 190, 30);
		panel_1.add(textField);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setBounds(66, 161, 89, 14);
		panel_1.add(lblProductName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(291, 179, 190, 30);
		panel_1.add(textField_1);
		
		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setForeground(Color.WHITE);
		lblProductPrice.setBounds(291, 161, 115, 14);
		panel_1.add(lblProductPrice);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 238, 190, 30);
		panel_1.add(textField_2);
		
		JLabel lblCategory = new JLabel("Quantity");
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setBounds(66, 220, 89, 14);
		panel_1.add(lblCategory);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(291, 238, 190, 30);
		panel_1.add(textField_3);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(291, 220, 46, 14);
		panel_1.add(lblDate);
		
		JButton btnUpdateExpense = new JButton("Update Expense");
		btnUpdateExpense.setBounds(184, 340, 153, 30);
		panel_1.add(btnUpdateExpense);
		
		JLabel lblCategory_1 = new JLabel("Category");
		lblCategory_1.setForeground(Color.WHITE);
		lblCategory_1.setBounds(66, 281, 89, 14);
		panel_1.add(lblCategory_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Utility.CATEGORY));
		comboBox.setBounds(66, 296, 415, 30);
		panel_1.add(comboBox);

	}
}
